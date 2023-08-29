package gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import render.Game;
import render.GamePanel;
import ui.bars.MainMenuBar;
import utilz.HelperMethods;
import utilz.constants.Constants;

public class MainMenu implements GameStateInterface {
    private Game game;
    private MainMenuBar mainMenuBar;

    public MainMenu(Game game) {
        this.game = game;
        this.mainMenuBar = new MainMenuBar(game);
    }

    public void render(Graphics g) {
        this.drawTitle(g);
        this.mainMenuBar.draw(g);
    }

    private void drawTitle(Graphics g) {
        g.setFont(Constants.Fonts.MAIN_MENU_TITLE_FONT);
        g.setColor(Color.WHITE);
        String title = "YLLAIMORA'S REVENGE";
        int xPos = HelperMethods.calcHorizCenter(g, GamePanel.SCREEN_WIDTH, title);
        g.drawString(title, xPos, 140);
    }

    @Override
    public void update() {
        mainMenuBar.update();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mainMenuBar.updateSelectedBtn(e);
    }

    @Override
    public void mouseClicked(int x, int y) {
        mainMenuBar.mouseClicked(x, y);
    }

    @Override
    public void mouseMoved(int x, int y) {
        this.mainMenuBar.mouseMoved(x, y);
    }

    public void MousePressed(int x, int y) {
        this.mainMenuBar.mousePressed(x, y);
    }

    public void mouseWheelMoved(int wheelRotation) {
    }
    
}
