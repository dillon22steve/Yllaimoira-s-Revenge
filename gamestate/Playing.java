package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import location.Location;
import utilz.constants.Constants;
import utilz.constants.LocationConstants;

public class Playing implements GameStateInterface {

    private Location currLocation;

    public Playing() {
		currLocation = LocationConstants.everton;
    } //constructor

    public void render(Graphics g) {
        currLocation.draw(g);
    } //render



    @Override
    public void update() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    } //update

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 'A':
                break;
            case 'S':
                break;
            case 'D':
                break;
            case 'W':
                break;
            case 'M':
                GameStates.GameState = GameStates.MAP;
                break;
            case 'J':
                GameStates.GameState = GameStates.QUEST_JOURNAL;
                break;
            case 'I':
                break;
            case 'C':
                GameStates.GameState = GameStates.CHARACTER_MENU;
                break;
            case Constants.KeyboardConstants.ESC:
                GameStates.GameState = GameStates.PAUSE_MENU;
                break;
        } //switch
    } //keyPressed

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    } //mouseClicked

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    } //mouseMoved

    public void mouseWheelMoved(int wheelRotation) {
    } //mouseWheelMoved


    public void setCurrLocation(Location location) {
        this.currLocation = location;
    } //setCurrLocation
    
}
