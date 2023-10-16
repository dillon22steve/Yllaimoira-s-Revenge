package editor.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import editor.Editor;
import editor.EditorPanel;
import utilz.constants.Constants;

public class ChooseBuilding {

    private String[] bldgNames;
    private char selectedIndex;

    private Editor editor;

    private static float opacity = 255;
    private static float opacityUpdate = 1.2f;

    public ChooseBuilding(Editor editor) {
        this.editor = editor;
        initBldgNames();
        selectedIndex = 0;
    } //constructor


    private void initBldgNames() {
        bldgNames = new String[4];
        bldgNames[0] = "Tavern";
        bldgNames[1] = "Noble Home";
        bldgNames[2] = "Weapon Shop";
        bldgNames[3] = "Inn";
    } //initBldgNames


    public void update() {
        updateOpacity();
    } //update
    
    private void updateOpacity() {
        if (opacity < 35) {
            opacity = 35;
            opacityUpdate *= -1;
        } else if (opacity > 255) {
            opacity = 255;
            opacityUpdate *= -1;
        } //if

        opacity -= opacityUpdate;
    } //updateOpacity


    public void draw(Graphics g) {
        int size = EditorPanel.TILE_SIZE;
        for (int i = 0; i < bldgNames.length; i++) {
            if (i == selectedIndex) {
                g.setColor(new Color(255, 255, 255, (int)opacity));
            } else {
                g.setColor(Color.WHITE);
            } //if

            g.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
            g.drawString(bldgNames[i], size, i * size + size);
        } //for
    } //draw


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case Constants.KeyboardConstants.DOWN:
                if (selectedIndex == bldgNames.length - 1) {
                    selectedIndex = 0;
                } else {
                    selectedIndex++;
                } //if
                break;
            case Constants.KeyboardConstants.UP:
                if (selectedIndex == 0) {
                    selectedIndex = (char)(bldgNames.length - 1);
                } else {
                    selectedIndex--;
                } //if
                break;
            case Constants.KeyboardConstants.ENTER:
                editor.getEditBuilding().resetSelected();
                editor.getEditBuilding().setBldgIndex(selectedIndex);
                EditorStates.setState(EditorStates.EDITOR_MODE);
                break;
        } //switch
    } //keyPressed


    public String getSelectedBldg() {

        switch (bldgNames[selectedIndex]) {
            case "Tavern":
                return "tavern/canmove";
            case "Noble Home":
                return "noble_home/canmove";
            case "Inn":
                return "inn/canmove";
            case "Weapon Shop":
                return "weapon_shop/canmove";
            default:
                return null;
        } //switch
    } //getSelectedBldg

} //ChooseBuilding
