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
    private MainMenuBar mainMenuBar;
    private Game game;

    public MainMenu(Game game) {
        this.mainMenuBar = new MainMenuBar(this);
        this.game = game;
    } //constructor

    public void render(Graphics g) {
        this.mainMenuBar.draw(g);
        this.drawTitle(g);
    } //render

    private void drawTitle(Graphics g) {
        g.setFont(Constants.Fonts.MAIN_MENU_TITLE_FONT);
        g.setColor(Color.WHITE);
        String title = "YLLAIMORA'S REVENGE";
        int xPos = HelperMethods.calcHorizCenter(g, GamePanel.SCREEN_WIDTH, title);
        //int xPos = HelperMethods.calcHorizCenter(g, GamePanel.GAMEPANEL_WIDTH, title);
        g.drawString(title, xPos, 140);
    } //drawTitle

    @Override
    public void update() {
        mainMenuBar.update();
    } //update

    @Override
    public void keyPressed(KeyEvent e) {
        mainMenuBar.updateSelectedBtn(e);
    } //keyPressed

    @Override
    public void mouseClicked(int x, int y) {
        mainMenuBar.mouseClicked(x, y);
    } //mouseClicked

    @Override
    public void mouseMoved(int x, int y) {
        this.mainMenuBar.mouseMoved(x, y);
    } //mouseMoved

    public void MousePressed(int x, int y) {
        this.mainMenuBar.mousePressed(x, y);
    } //mousePressed

    public void mouseWheelMoved(int wheelRotation) {
        this.mainMenuBar.mouseWheelMoved(wheelRotation);
    } //mouseWheelMoved


    public Game getGame() {
        return this.game;
    } //getGame
    
} //MainMenu
