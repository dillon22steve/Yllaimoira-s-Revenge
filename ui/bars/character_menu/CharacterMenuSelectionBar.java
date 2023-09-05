package ui.bars.character_menu;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gamestate.GameStates;
import ui.bars.ButtonBar;
import ui.buttons.character_menu.CharMenuBtn;
import utilz.HelperMethods;
import utilz.constants.Constants;

public class CharacterMenuSelectionBar extends ButtonBar {

    private CharMenuBtn lvlUpBtn, invBtn, questJourBtn, backBtn;
    private CharMenuBtn[] btns;
    private int selectionID = 0;

    public CharacterMenuSelectionBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        initBtns();
    } //constructor


    private void initBtns() {
        int lvlUpX = (this.width/2 - (HelperMethods.calcX(75) / 2));
        lvlUpBtn = new CharMenuBtn("Level Up", 75, 40, lvlUpX, 100, (char)(0));

        int midBtnY = (this.height/2 - (HelperMethods.calcY(40) / 2));
        invBtn = new CharMenuBtn("Inventory", 75, 40, 200, midBtnY, (char)(1));
        questJourBtn = new CharMenuBtn("Quests", 75, 40, (this.width - 200), midBtnY, (char)(2));

        backBtn = new CharMenuBtn("Back", 75, 40, lvlUpX, this.height - 100, (char)(3));

        btns = new CharMenuBtn[4];
        btns[0] = lvlUpBtn;
        btns[1] = invBtn;
        btns[2] = questJourBtn;
        btns[3] = backBtn;
    } //initBtns


    public void draw(Graphics g) {
        for (int i = 0; i < btns.length; i++) btns[i].draw(g);
    } //draw


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.UP:
                //Setting the selected button to the level up button
                btns[selectionID].setSelected(false);
                selectionID = 0;
                btns[selectionID].setSelected(true);
                break;
            case Constants.KeyboardConstants.DOWN:
                //Setting the selected button to the back button
                btns[selectionID].setSelected(false);
                selectionID = 3;
                btns[selectionID].setSelected(true);
                break;
            case Constants.KeyboardConstants.RIGHT:
                //Setting the selected button to the quest journal button
                btns[selectionID].setSelected(false);
                selectionID = 2;
                btns[selectionID].setSelected(true);
                break;
            case Constants.KeyboardConstants.LEFT:
                //Setting the selected button to the inventory button
                btns[selectionID].setSelected(false);
                selectionID = 1;
                btns[selectionID].setSelected(true);
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
        for (int i = 0; i < btns.length; i++) {
            if (btns[i].getBounds().contains(x, y)) {
                //change states depending on which button is clicked
            } //if
        } //for
    } //mouseClicked

    public void mouseMoved(int x, int y) {
        btns[selectionID].setSelected(false);
        for (int i = 0; i < btns.length; i++) {
            if (btns[i].getBounds().contains(x, y)) {
                selectionID = i;
                btns[selectionID].setSelected(true);
            } //if
        } //for
    } //mouseMoved


    public void mouseWheelMoved(int wheelRotation) {
        btns[selectionID].setSelected(false);

        if (wheelRotation < 0) {
            if (selectionID < btns.length - 1) {
                    selectionID++;
            } else {
                    selectionID = 0;
            } //if
        } else {
            if (selectionID > 0) {
                    selectionID--;
            } else {
                    selectionID = (btns.length - 1);
            } //if
        } //if

        btns[selectionID].setSelected(true);
    } //mouseWheelMoved

}
