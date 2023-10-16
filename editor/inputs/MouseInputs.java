package editor.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import editor.Editor;
import editor.states.EditorStates;

public class MouseInputs implements MouseListener, MouseMotionListener {

    private Editor editor;

    public MouseInputs(Editor editor) {
        this.editor = editor;
    } //constructor


    @Override
    public void mouseDragged(MouseEvent e) {
        
    } //mouseDragged

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (EditorStates.EditorState) {
            case CHOOSE_BUILDING:

                break;
            case EDITOR_MODE:
                editor.getEditBuilding().mouseMoved(e.getX(), e.getY());
                break;
        } //switch
    } //mouseMoved

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (EditorStates.EditorState) {
            case CHOOSE_BUILDING:

                break;
            case EDITOR_MODE:
                editor.getEditBuilding().mouseClicked();
                break;
        } //switch
    } //mouseClicked

    @Override
    public void mousePressed(MouseEvent e) {
        
    } //mousePressed

    @Override
    public void mouseReleased(MouseEvent e) {
        
    } //mouseReleased

    @Override
    public void mouseEntered(MouseEvent e) {
        
    } //mouseEntered

    @Override
    public void mouseExited(MouseEvent e) {
        
    } //mouseExited

} //MouseInputs
