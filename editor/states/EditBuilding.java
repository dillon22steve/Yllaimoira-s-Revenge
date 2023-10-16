package editor.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import editor.EditorPanel;
import utilz.HelperMethods;
import utilz.constants.Constants;

public class EditBuilding {

    private BufferedImage[] bldgs;
    private int bldgIndex;

    private Rectangle usersMouse;
    private Color usersMouseColor;
    private Color selectedRectColor;
    private ArrayList<Rectangle> selectedTiles;

    public EditBuilding() {
        loadBldgs();
        this.usersMouse = new Rectangle(0, 0, EditorPanel.TILE_SIZE, EditorPanel.TILE_SIZE);
        usersMouseColor = new Color(0, 100, 100, 30);
        selectedRectColor = new Color(144, 238, 144, 30);
        this.selectedTiles = new ArrayList<Rectangle>();
    } //constructor


    private void loadBldgs() {
        bldgs = new BufferedImage[1];
        bldgs[0] = HelperMethods.LoadImage("buildings/tavern/TavernInterior.jpg");
    } //loadBldgs


    public void update() {

    } //update


    public void draw(Graphics g) {
        int size = EditorPanel.TILE_SIZE;
        int width = bldgs[bldgIndex].getWidth() / size;
        int height = bldgs[bldgIndex].getHeight() / size;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int xPos = j * size;
                int yPos = i * size;
                BufferedImage img = bldgs[bldgIndex].getSubimage(xPos, yPos, size, size);
                g.drawImage(img, xPos, yPos, size, size, null);
            } //for
        } //for

        g.setColor(usersMouseColor);
        g.fillRect((int)usersMouse.getX(), (int)usersMouse.getY(), size, size);

        g.setColor(selectedRectColor);
        for (int i = 0; i < selectedTiles.size(); i++) {
            Rectangle rect = selectedTiles.get(i);
            g.fillRect((int)rect.getX(), (int)rect.getY(), size, size);
        } //for
    } //draw


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case Constants.KeyboardConstants.ESC:
                EditorStates.setState(EditorStates.PAUSE);
                break;
        } //switch
    } //keyPressed


    public void mouseMoved(int x, int y) {
        int newX = (x / 64) * 64;
        int newY = (y / 64) * 64;
        usersMouse.setLocation(newX, newY);
    } //mouseMoved

    public void mouseClicked() {
        int size = EditorPanel.TILE_SIZE;
        
        //Checks if the tile the user selected is already in the list. If it is, it will remove
        //that tile from the list.
        for (int i = 0; i < selectedTiles.size(); i++) {
            if (selectedTiles.get(i).contains(usersMouse.getX(), usersMouse.getY())) {
                selectedTiles.remove(i);
                return;
            } //if
        } //for

        //if the tile the user clicked on is not already selected, it will add that tile to the list.
        Rectangle rectToAdd = new Rectangle((int)usersMouse.getX(), (int)usersMouse.getY(), size, size);
        selectedTiles.add(rectToAdd);
    } //mouseClicked


    public int getBldgIndex() {
        return bldgIndex;
    } //getBldgIndex

    public void setBldgIndex(int bldgIndex) {
        this.bldgIndex = bldgIndex;
    } //setBldgIndex


    public ArrayList<Rectangle> getSelectedTiles() {
        return selectedTiles;
    } //setSelectedTiles

    public void resetSelected() {
        for (int i = 0; i < selectedTiles.size(); i++) {
            selectedTiles.remove(i);
        } //for
    } //resetSelected
    
} //EditBuilding
