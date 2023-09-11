package ui.bars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gamestate.GameStates;
import ui.buttons.*;
import utilz.HelperMethods;
import utilz.constants.Constants;
import utilz.constants.LocationConstants;
import render.GamePanel;

public class MainMenuBar extends ButtonBar {
    private static final int NEWGAMEID = 1;
    private static final int CONTINUEID = 2;
    private static final int LOADID = 3;
    private static final int QUITID = 4;
    private int selectedBtn = 1;

    MainMenuBtn continueBtn, loadBtn, quitBtn, newGameBtn;
    boolean mouseOver = false;

    public MainMenuBar() {
        //super(300, 700, (int)(game.getGamePanel().getWidth() / 2 - 150), 300);
        //super(GamePanel.GAMEPANEL_WIDTH, GamePanel.GAMEPANEL_HEIGHT, 0, 0);
        super(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT, 0, 0);
        initBtns();
    }

    public void initBtns() {
        int btnXPos = (this.xPos + (this.width / 2 - 50));

        this.newGameBtn = new MainMenuBtn("New Game", 100, 30, btnXPos, HelperMethods.calcY(330));
        this.newGameBtn.setSelected(true);

        this.continueBtn = new MainMenuBtn("Continue", 100, 30, btnXPos, HelperMethods.calcY(430));
        this.loadBtn = new MainMenuBtn("Load", 100, 30, btnXPos, HelperMethods.calcY(530));
        this.quitBtn = new MainMenuBtn("Quit", 100, 30, btnXPos, HelperMethods.calcY(630));
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        drawBody(g);
        drawBtns(g);
    }

    public void drawBody(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(xPos, yPos, width, height);
    }

    public void drawBtns(Graphics g) {
        this.newGameBtn.draw(g);
        this.continueBtn.draw(g);
        this.loadBtn.draw(g);
        this.quitBtn.draw(g);
    }


    public void update() {
        MainMenuBtn.updateOpacity();
    }

    public void updateSelectedBtn(KeyEvent e) {
        resetSelection();
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.UP:
                if (selectedBtn == NEWGAMEID) {
                    selectedBtn = QUITID;
                    quitBtn.setSelected(true);
                } else if (selectedBtn == CONTINUEID) {
                    selectedBtn = NEWGAMEID;
                    newGameBtn.setSelected(true);
                } else if (selectedBtn == LOADID) {
                    selectedBtn = CONTINUEID;
                    continueBtn.setSelected(true);
                } else if (selectedBtn == QUITID) {
                    selectedBtn = LOADID;
                    loadBtn.setSelected(true);
                }
                break;
            case Constants.KeyboardConstants.DOWN:
                if (selectedBtn == NEWGAMEID) {
                    selectedBtn = CONTINUEID;
                    continueBtn.setSelected(true);
                } else if (selectedBtn == CONTINUEID) {
                    selectedBtn = LOADID;
                    loadBtn.setSelected(true);
                } else if (selectedBtn == LOADID) {
                    selectedBtn = QUITID;
                    quitBtn.setSelected(true);
                } else if (selectedBtn == QUITID) {
                    selectedBtn = NEWGAMEID;
                    newGameBtn.setSelected(true);
                }
                break;
            case Constants.KeyboardConstants.ENTER:
                if (selectedBtn == NEWGAMEID) {
                    LocationConstants.InitLocations();

                    GameStates.GameState = GameStates.CHARACTER_CREATION;
                } else if (selectedBtn == CONTINUEID) {
                    //need to implement a method that loads the last save.
                } else if (selectedBtn == LOADID) {
                    //need to implement a method that lists all of the saved files and lets
                    //the user choose which one to load.
                } else if (selectedBtn == QUITID) {
                    System.exit(0);
                    //need to implement a method that asks the user if they're sure they want
                    //to quit the game.
                }
                break;
        }
    }



    public void mouseClicked(int x, int y) {
        if(continueBtn.getBounds().contains(x, y)) {

        } else if (loadBtn.getBounds().contains(x, y)) {

        } else if (newGameBtn.getBounds().contains(x, y)) {
            LocationConstants.InitLocations();
            GameStates.GameState = GameStates.CHARACTER_CREATION;
        } else if (quitBtn.getBounds().contains(x, y)) {
            System.exit(0);
        }
    }
    public void mouseMoved(int x, int y) {
        resetBooleans();
        if (continueBtn.getBounds().contains(x, y)) {
            continueBtn.setMouseOver(true);
            resetSelection();
            continueBtn.setSelected(true);
        } else if (loadBtn.getBounds().contains(x, y)) {
            loadBtn.setMouseOver(true);
            resetSelection();
            loadBtn.setSelected(true);
        } else if (newGameBtn.getBounds().contains(x, y)) {
            newGameBtn.setMouseOver(true);
            resetSelection();
            newGameBtn.setSelected(true);
        } else if (quitBtn.getBounds().contains(x, y)) {
            quitBtn.setMouseOver(true);
            resetSelection();
            quitBtn.setSelected(true);
        }
    }
    public void mousePressed(int x, int y) {
        resetBooleans();
        if (continueBtn.getBounds().contains(x, y)) {
            continueBtn.setMousePressed(true);
        } else if (loadBtn.getBounds().contains(x, y)) {
            loadBtn.setMousePressed(true);
        } else if (newGameBtn.getBounds().contains(x, y)) {
            newGameBtn.setMousePressed(true);
        } else if (quitBtn.getBounds().contains(x, y)) {
            quitBtn.setMousePressed(true);
        }
    }
    public void mouseReleased(int x, int y) {
        resetBooleans();
    }
    public void resetBooleans() {
        continueBtn.resetBooleans();
        loadBtn.resetBooleans();
        newGameBtn.resetBooleans();
        quitBtn.resetBooleans();
    }
    public void resetSelection() {
        newGameBtn.setSelected(false);
        loadBtn.setSelected(false);
        continueBtn.setSelected(false);
        quitBtn.setSelected(false);
    }

    public void mouseWheelMoved(int wheelRotation) {
        if (wheelRotation > 0) {
            resetSelection();
            switch(selectedBtn) {
                case NEWGAMEID:
                    selectedBtn = QUITID;
                    newGameBtn.setSelected(false);
                    quitBtn.setSelected(true);
                    break;
                case CONTINUEID:
                    selectedBtn = NEWGAMEID;
                    continueBtn.setSelected(false);
                    newGameBtn.setSelected(true);
                    break;
                case LOADID:
                    selectedBtn = CONTINUEID;
                    loadBtn.setSelected(false);
                    continueBtn.setSelected(true);
                    break;
                case QUITID:
                    selectedBtn = LOADID;
                    quitBtn.setSelected(false);
                    loadBtn.setSelected(true);
                    break;
            }
        } else {
            switch(selectedBtn) {
                case NEWGAMEID:
                    selectedBtn = CONTINUEID;
                    newGameBtn.setSelected(false);
                    continueBtn.setSelected(true);
                    break;
                case CONTINUEID:
                    selectedBtn = LOADID;
                    continueBtn.setSelected(false);
                    loadBtn.setSelected(true);
                    break;
                case LOADID:
                    selectedBtn = QUITID;
                    loadBtn.setSelected(false);
                    quitBtn.setSelected(true);
                    break;
                case QUITID:
                    selectedBtn = NEWGAMEID;
                    quitBtn.setSelected(false);
                    newGameBtn.setSelected(true);
                    break;
            }
        }
    }
}
