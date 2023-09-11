package ui.bars.character_menu;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import gamestate.GameStates;
import ui.bars.ButtonBar;
import ui.buttons.character_menu.CharMenuBtn;
import utilz.HelperMethods;
import utilz.constants.Constants;

public class CharacterMenuSelectionBar extends ButtonBar {

    private BufferedImage scroll;
    private int scrollWidth, scrollHeight, scrollX, scrollY;

    private CharMenuBtn lvlUpBtn, invBtn, questJourBtn, backBtn;
    private CharMenuBtn[] btns;
    private int selectionID = 0;

    public CharacterMenuSelectionBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        initBtns();
        initScroll();
    } //constructor


    private void initBtns() {
        int buttonWidth = HelperMethods.calcX(75);
        int buttonHeight = HelperMethods.calcY(40);
        int buttonX = (this.width/2 - (buttonWidth / 2));
        int buttonY = HelperMethods.calcY(290);
        int yOffset = HelperMethods.calcY(100);

        lvlUpBtn = new CharMenuBtn("Level Up", buttonWidth, buttonHeight, buttonX, buttonY);
        invBtn = new CharMenuBtn("Inventory", buttonWidth, buttonHeight, buttonX, (buttonY + yOffset));
        questJourBtn = new CharMenuBtn("Quests", buttonWidth, buttonHeight, buttonX, (buttonY + yOffset*2));
        backBtn = new CharMenuBtn("Back", buttonWidth, buttonHeight, buttonX, (buttonY + yOffset*3));

        btns = new CharMenuBtn[4];
        btns[0] = lvlUpBtn;
        btns[1] = invBtn;
        btns[2] = questJourBtn;
        btns[3] = backBtn;
    } //initBtns


    private void initScroll() {
        scroll = HelperMethods.LoadImage("Scroll.png");
        scrollWidth = HelperMethods.calcX(1280);
        scrollHeight = HelperMethods.calcY(720);
        scrollX = ((this.width / 2) - (scrollWidth / 2));
        scrollY = HelperMethods.calcY(160);
    }


    public void draw(Graphics g) {
        g.drawImage(scroll, scrollX, scrollY, scrollWidth, scrollHeight, null);
        for (int i = 0; i < btns.length; i++) btns[i].draw(g);
    } //draw


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.UP:
                updateSelection(false);
                break;
            case Constants.KeyboardConstants.DOWN:
                updateSelection(true);
                break;
            case Constants.KeyboardConstants.ENTER:
                if (selectionID == 0) {
                    //go to the level up screen
                } else if (selectionID == 1) {
                    //go to the inventory screen
                } else if (selectionID == 2) {
                    //go to the quest journal screen
                } else if (selectionID == 3) {
                    GameStates.GameState = GameStates.PLAYING;
                } //if
                break;
            case Constants.KeyboardConstants.ESC:
                GameStates.GameState = GameStates.PLAYING;
                break;
        }
    } //keyPressed

    public void mouseClicked(int x, int y) {
        switch(selectionID) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                GameStates.GameState = GameStates.PLAYING;
                break;
        }
    } //mouseClicked

    public void mouseMoved(int x, int y) {
        for (int i = 0; i < btns.length; i++) {
            if (btns[i].getBounds().contains(x, y)) {
                btns[selectionID].setSelected(false);
                selectionID = i;
                btns[selectionID].setSelected(true);
            } //if
        } //for
    } //mouseMoved


    public void mouseWheelMoved(int wheelRotation) {
        if (wheelRotation < 0) {
            updateSelection(false);
        } else {
            updateSelection(true);
        } //if
    } //mouseWheelMoved


    private void updateSelection(boolean down) {
        btns[selectionID].setSelected(false);

        if (down) {
            if (selectionID < btns.length - 1) {
                selectionID++;
            } else {
                selectionID = 0;
            }
        } else {
            if (selectionID > 0) {
                selectionID--;
            } else {
                selectionID = (btns.length - 1);
            } //if
        } //if

        btns[selectionID].setSelected(true);
    } //updateSelection

}
