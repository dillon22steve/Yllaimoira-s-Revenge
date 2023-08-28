package gamestate;

import java.awt.event.KeyEvent;


public interface GameStateInterface {
    void update();

    void keyPressed(KeyEvent e);

    void mouseClicked(int x, int y);

    void mouseMoved(int x, int y);
}
