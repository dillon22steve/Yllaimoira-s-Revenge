package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import render.GamePanel;
import ui.bars.PauseMenuBar;

public class PauseMenu implements GameStateInterface {
    private PauseMenuBar pauseMenu;

    public PauseMenu() {
        int width = 200;
        int height = 350;
        // int x = GamePanel.GAMEPANEL_WIDTH/2 - width/2;
        // int y = GamePanel.GAMEPANEL_HEIGHT/2 - height/2;
        int x = GamePanel.SCREEN_WIDTH/2 - width/2;
        int y = GamePanel.SCREEN_HEIGHT/2 - height/2;
        pauseMenu = new PauseMenuBar(width, height, x, y);
    }

    public void render(Graphics g) {
        pauseMenu.draw(g);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pauseMenu.keyPressed(e);
    }

    @Override
    public void mouseClicked(int x, int y) {
        pauseMenu.mouseClicked(x, y);
    }

    @Override
    public void mouseMoved(int x, int y) {
        pauseMenu.mouseMoved(x, y);
    }

    public void mouseWheelMoved(int wheelRotation) {
        pauseMenu.mouseWheelMoved(wheelRotation);
    }
    
}
