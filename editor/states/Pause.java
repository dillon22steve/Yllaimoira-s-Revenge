package editor.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import editor.Editor;
import editor.EditorPanel;
import utilz.HelperMethods;
import utilz.constants.Constants;

public class Pause {

    private static String homePath = System.getProperty("user.home");
    public static String saveFolder = "CanMoveEditor";
    public static String filePath = homePath + File.separator + saveFolder + File.separator;
    public static String file = filePath + "can-move-editor.txt";

    private Editor editor;

    private String[] options;
    private char selectedIndex;

    private static float opacity = 255;
    private static float opacityUpdate = 1.2f;
    
    public Pause(Editor editor) {
        this.editor = editor;
        options = new String[3];
        selectedIndex = 0;
        options[0] = "Return";
        options[1] = "Save";
        options[2] = "Choose Location";
        createFolder();
    } //constructor

    public void createFolder() {
		File folder = new File(homePath + File.separator + saveFolder);
		if (!folder.exists()) {
			folder.mkdir();
        } //if
	} //createFolder



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
        g.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        int startY = (EditorPanel.SCREEN_HEIGHT / 2) - (size * 2);

        for (int i = 0; i < options.length; i++) {
            if (i == selectedIndex) {
                g.setColor(new Color(255, 255, 255, (int)opacity));
            } else {
                g.setColor(Color.WHITE);
            } //if

            int x = HelperMethods.calcHorizCenter(g, EditorPanel.SCREEN_WIDTH, options[i]);
            g.drawString(options[i], x, (startY + ((size * 2) * i)));
        } //for
    } //draw


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case Constants.KeyboardConstants.DOWN:
                if (selectedIndex == options.length - 1) {
                    selectedIndex = 0;
                } else {
                    selectedIndex++;
                } //if
                break;
            case Constants.KeyboardConstants.UP:
                if (selectedIndex == 0) {
                    selectedIndex = (char)(options.length - 1);
                } else {
                    selectedIndex--;
                } //if
                break;
            case Constants.KeyboardConstants.ENTER:
                if (selectedIndex == 0) {
                    EditorStates.setState(EditorStates.EDITOR_MODE);
                } else if (selectedIndex == 1) {
                    String bldgName = editor.getChooseBuilding().getSelectedBldg();
                    writeToFile(bldgName);
                } else {
                    EditorStates.setState(EditorStates.CHOOSE_BUILDING);
                } //if
                break;
            case Constants.KeyboardConstants.ESC:
                EditorStates.setState(EditorStates.EDITOR_MODE);
                break;
        } //switch
    } //keyPressed


    public void writeToFile(String bldgName) {
        try {
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < editor.getEditBuilding().getSelectedTiles().size(); i++) {
                int x = (int)(editor.getEditBuilding().getSelectedTiles().get(i).getX()) / 64;
                int y = (int)(editor.getEditBuilding().getSelectedTiles().get(i).getY()) / 64;
                pw.print(x);
                pw.print(" ");
                pw.print(y);
                pw.print("\n");
            } //for
            pw.close();
            } catch (IOException io) {
                System.out.println(io.getMessage());
        } //try
    } //writeToFile

} //Pause
