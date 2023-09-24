package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import location.Location;
import render.Game;
import utilz.constants.Constants;
import utilz.constants.LocationConstants;

public class Playing implements GameStateInterface {

    private Location currLocation;
    private Game game;

    public Playing(Game game) {
		currLocation = LocationConstants.everton;
        currLocation.calcOffsetsAndBorders();
        this.game = game;
    } //constructor

    public void render(Graphics g) {
        currLocation.draw(g, game.getPlayer());
    } //render



    @Override
    public void update() {
        currLocation.update();
    } //update

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 'A':
                currLocation.setLeft(true);
                currLocation.setRight(false);
                break;
            case 'S':
                currLocation.setDown(true);
                currLocation.setUp(false);
                break;
            case 'D':
                currLocation.setRight(true);
                currLocation.setLeft(false);
                break;
            case 'W':
                currLocation.setUp(true);
                currLocation.setDown(false);
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

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 'A':
                currLocation.setLeft(false);
                break;
            case 'S':
                currLocation.setDown(false);
                break;
            case 'D':
                currLocation.setRight(false);
                break;
            case 'W':
                currLocation.setUp(false);
                break;
        }
    } //keyReleased

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
