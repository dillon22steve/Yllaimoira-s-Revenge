package ui.bars.character_creation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gamestate.GameStates;
import ui.bars.ButtonBar;
import ui.buttons.CharCreatBtn;
import utilz.Constants;
import utilz.Enums;

public class CharacterCreationBar extends ButtonBar {
    int btnWidth = this.width / 17;
    int btnHeight = this.height / 25;
    int y = this.height / 10;
    int x = this.width / 26;
    int yOffset = this.height / 14;
    CharCreatBtn[] btns = null;

    CharCreatBtn confirmSelecBtn;
    int confirmBtnX = (int)(0.55 * this.width);
    int confirmBtnY = (int)(0.92* this.height);

    public static int selection = 0;

    String selectedName = "";
    String attributes = "";
    String desc = "";

    boolean isSelected = false;

    public CharacterCreationBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);

        confirmSelecBtn = new CharCreatBtn("Yes", btnWidth, btnHeight, confirmBtnX, confirmBtnY);
    }

    public void drawButtons(Graphics g) {
        for (int i = 0; i < btns.length; i++) {
            if (i == selection) {
                g.setColor(Color.WHITE);
                g.setFont(Constants.Fonts.CHAR_CREAT_BTN_FONT);
                g.drawString("> ", (btns[i].getX() - (int)(0.013 * this.width)), btns[i].getY());
            }

            btns[i].draw(g);

            if (isSelected) {
                drawConfirmSelection(g);
            }
        }
    }


    private void drawConfirmSelection(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(Constants.Fonts.CHAR_CREAT_BTN_FONT);
        g.drawString(("Continue as a " + selectedName + "?"), (int)(0.325 * this.width), confirmBtnY);
        confirmSelecBtn.draw(g);
    }


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.UP:
                isSelected = false;
                if(selection > 0) {
                    selection = selection - 1;
                } else {
                    selection = (btns.length - 1);
                } //if
                break;
            case Constants.KeyboardConstants.DOWN:
                isSelected = false;
                if (selection < (btns.length - 1)) {
                    selection = selection + 1;
                } else {
                    selection = 0;
                } //if
                break;
            case Constants.KeyboardConstants.ENTER:
                if (isSelected == true) {
                    changeState();
                } else {
                    isSelected = true;
                }
                break;
        } //switch
    } //keyPressed


    public void mouseMoved(int x, int y) {
        for (int i = 0; i < btns.length; i++) {
            if ((btns[i].getBounds().contains(x, (y - 25))) ||
                (btns[i].getBounds().contains(x, (y + 25)))) {
                selection = i;
            } //if
        } //for
    } //mouseMoved


    public void mouseClicked(int x, int y) {
        if (isSelected == true && (confirmSelecBtn.getBounds().contains(x, y - 25)) ||
            confirmSelecBtn.getBounds().contains(x, y + 25)) {
            changeState();
            return;
        }
        for (int i = 0; i < btns.length; i++) {
            if ((btns[i].getBounds().contains(x, (y - 25))) ||
                (btns[i].getBounds().contains(x, (y + 25)))) {
                isSelected = true;
                selection = i;
            } //if
        } //for
    } //mouseClicked

    public void mouseWheelMoved(int wheelRotation) {
        isSelected = false;
        if (wheelRotation < 0) {
            if (selection > 0) {
                selection -= 1;
            } else if (selection == 0) {
                selection = (btns.length - 1);
            } //if
        } else {
            if (selection < (btns.length - 1)) {
                selection += 1;
            } else if (selection == (btns.length - 1)) {
                selection = 0;
            } //if
        } //if
    } //mouseWheelMoved

    private void changeState() {
        if (Enums.CharacterCreationStates.State == Enums.CharacterCreationStates.RACE_SELECT) {
            Enums.CharacterCreationStates.State = Enums.CharacterCreationStates.CLASS_SELECT;
        } else if (Enums.CharacterCreationStates.State == Enums.CharacterCreationStates.CLASS_SELECT) {
            Enums.CharacterCreationStates.State = Enums.CharacterCreationStates.BACKGROUND_SELECT;
        } else if (Enums.CharacterCreationStates.State == Enums.CharacterCreationStates.BACKGROUND_SELECT) {
            GameStates.GameState = GameStates.PLAYING;
        }
    }
    
}
