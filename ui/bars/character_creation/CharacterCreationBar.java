package ui.bars.character_creation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gamestate.GameStates;
import ui.bars.ButtonBar;
import ui.buttons.CharCreatBtn;
import utilz.Enums;
import utilz.HelperMethods;
import utilz.constants.Constants;

public class CharacterCreationBar extends ButtonBar {
    CharCreatBtn[] btns = null;

    CharCreatBtn confirmSelecBtn;

    int selection = 0;

    String selectedName = "";
    String attributes = "";
    String desc = "";

    boolean isSelected = false;

    public CharacterCreationBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        confirmSelecBtn = new CharCreatBtn("Yes", 75, 40, HelperMethods.calcX(850), HelperMethods.calcY(800));
    }

    public void drawButtons(Graphics g) {
        for (int i = 0; i < btns.length; i++) {
            if (i == selection) {
                g.setColor(Color.WHITE);
                g.setFont(Constants.Fonts.CHAR_CREAT_BTN_FONT);
                g.drawString("> ", btns[i].getX() - 20, btns[i].getYPos());
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
        String contPrompt = "Continue as a " + selectedName + "?";
        g.drawString(contPrompt, HelperMethods.calcX(500), HelperMethods.calcY(800));
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
