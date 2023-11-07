package ui.bars.combat_menu;

import java.awt.event.KeyEvent;

import characters.playable.Playable;
import gamestate.Combat;
import ui.buttons.CombatMenuBtn;
import utilz.constants.Constants;

public class ActionMenuBar extends CombatMenuBar {

    private Playable currentCharacter;

    public ActionMenuBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        initButtons();
    } //constructor

    private void initButtons() {
        btns = new CombatMenuBtn[5];
        int btnWidth = this.width / 2;
        int btnHeight = this.height / 2;
        this.setHeight(height + btnHeight);
        
        btns[0] = new CombatMenuBtn("", btnWidth, btnHeight, this.xPos, this.yPos);
        btns[1] = new CombatMenuBtn("", btnWidth, btnHeight, this.xPos + btnWidth, this.yPos);
        btns[2] = new CombatMenuBtn("", btnWidth, btnHeight, this.xPos, this.yPos + btnHeight);
        btns[3] = new CombatMenuBtn("", btnWidth, btnHeight, this.xPos + btnWidth, this.yPos + btnHeight);
        btns[4] = new CombatMenuBtn("Back", this.width, btnHeight, this.xPos, (this.yPos + 2*btnHeight));
    } //initButtons


    public void updateButtons(char barType, Playable character) {
        if (barType == 'a') {
            //Update this later when I add attacks for the characters
            btns[0].setTxt("Firebolt");
            btns[1].setTxt("Fireball");
            btns[2].setTxt("Frostbite");
            btns[3].setTxt("Thunderbolt");
        } else if (barType == 'p') {
            //Update this later when I add the characters' inventories and potions.
            btns[0].setTxt("Lesser potion");
            btns[1].setTxt("Apprentice potion");
            btns[2].setTxt("Greater potion");
            btns[3].setTxt("Master potion");
        } //if
    } //updateButtons


    protected void updateBtnBounds(int y) {
        btns[0].setYPos(y);
        btns[1].setYPos(y);
        btns[2].setYPos(y + btns[2].getHeight());
        btns[3].setYPos(y + btns[3].getHeight());
        btns[4].setYPos(y + (btns[4].getHeight() * 2));

        for (int i = 0; i < btns.length; i++) {
            btns[i].getBounds().setLocation(btns[i].getX(), btns[i].getYPos());
        } //for
    } //updateBtnBounds


    public void keyPressed(KeyEvent e, Combat combat) {
        switch (e.getKeyCode()) {
            case Constants.KeyboardConstants.ENTER:
                if (selectedIndex == 4) {
                    combat.setCombatState('s');
                } else {
                    //Need to update this later so that the player attacks or drinks a potion
                    //depending on what they selected.
                    
                } //if
                break;
        } //switch
    } //keyPressed


    public void mouseClicked(int x, int y, Combat combat) {
        if (btns[4].getBounds().contains(x, y)) {
            combat.setCombatState('s');
        } else {
            for (int i = 0; i < btns.length - 1; i++) {
                if (btns[i].getBounds().contains(x, y)) {
                    //Need to update this later so that the player attacks or drinks a potion
                    //depending on what they selected.

                    return;
                } //if
            } //for
        } //if
    } //mouseClicked


    public void mouseMoved(int x, int y) {
        if (x >= this.xPos && y >= this.yPos && y <= (this.yPos + this.height)) {
            for (int i = 0; i < btns.length; i++) {
                if (btns[i].getBounds().contains(x, y)) {
                    updateSelection(i);
                } //if
            } //for
        } //if
    } //mouseMoved
    
} //AttackMenuBar
