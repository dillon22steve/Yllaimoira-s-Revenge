package editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import editor.inputs.KeyboardInputs;
import editor.inputs.MouseInputs;
import editor.states.EditorStates;
import utilz.HelperMethods;

public class EditorPanel extends JPanel {
    
    public static int SCREEN_HEIGHT;
    public static int SCREEN_WIDTH;

    public static int TILE_SIZE;
    public static int TILES_WIDE;
    public static int TILES_HIGH;

    private Dimension screenSize;

    private Editor editor;
    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;

    public EditorPanel(Editor editor) {
        this.editor = editor;
        setPanelSize();
        this.setBackground(Color.BLACK);
    } //constructor


    private void setPanelSize() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_WIDTH = (int)screenSize.getWidth();
        SCREEN_HEIGHT = (int)screenSize.getHeight();
        screenSize = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

        TILE_SIZE = 64;
        TILES_WIDE = HelperMethods.CalcTilesWide(SCREEN_WIDTH, TILE_SIZE);
        TILES_HIGH = HelperMethods.CalcTilesWide(SCREEN_HEIGHT, TILE_SIZE);

        setMinimumSize(screenSize);
        setPreferredSize(screenSize);
    } //setPanelSize


    public void initInputs() {
        this.keyboardInputs = new KeyboardInputs(this.editor);
        this.mouseInputs = new MouseInputs(this.editor);

        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        addKeyListener(keyboardInputs);

        requestFocus();
    } //initInputs


    public void update() {
        switch(EditorStates.EditorState) {
            case EDITOR_MODE:
                editor.getEditBuilding().update();
                break;
            case CHOOSE_BUILDING:
                editor.getChooseBuilding().update();
                break;
            case PAUSE:
                editor.getPause().update();
                break;
        } //switch
    } //update


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch(EditorStates.EditorState) {
            case EDITOR_MODE:
                editor.getEditBuilding().draw(g);
                break;
            case CHOOSE_BUILDING:
                editor.getChooseBuilding().draw(g);
                break;
            case PAUSE:
                editor.getPause().draw(g);
                break;
        } //switch
    } //paintComponent

} //EditorPanel
