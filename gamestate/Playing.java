package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import utilz.Constants;

public class Playing implements GameStateInterface {

    public void render(Graphics g) {
        g.drawString("Hello World", 50, 50);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

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
        }
    }

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    public void mouseWheelMoved(int wheelRotation) {
    }
    
}