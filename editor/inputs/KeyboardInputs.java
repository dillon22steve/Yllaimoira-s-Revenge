package editor.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import editor.Editor;
import editor.states.EditorStates;

public class KeyboardInputs implements KeyListener {

    private Editor editor;

    public KeyboardInputs(Editor editor) {
        this.editor = editor;
    } //constructor

    @Override
    public void keyTyped(KeyEvent e) {
        
    } //keyTyped

    @Override
    public void keyPressed(KeyEvent e) {
        switch (EditorStates.EditorState) {
            case CHOOSE_BUILDING:
                editor.getChooseBuilding().keyPressed(e);
                break;
            case EDITOR_MODE:
                editor.getEditBuilding().keyPressed(e);
                break;
            case PAUSE:
                editor.getPause().keyPressed(e);
                break;
        } //switch
    } //keyPressed

    @Override
    public void keyReleased(KeyEvent e) {
        
    } //keyReleased
    
} //KeyboardInputs
