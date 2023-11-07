package ui.bars.combat_menu;

import java.awt.event.KeyEvent;

import gamestate.Combat;
import ui.buttons.CombatMenuBtn;
import utilz.constants.Constants;

public class SelectionBar extends CombatMenuBar {
    
    public SelectionBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        initButtons();
    } //constructor

    private void initButtons() {
        btns = new CombatMenuBtn[3];
        int btnWidth = this.width / 2;
        int btnHeight = this.height / 2;
        btns[0] = new CombatMenuBtn("Attack", btnWidth, btnHeight, this.xPos, this.yPos);
        btns[1] = new CombatMenuBtn("Potions", btnWidth, btnHeight, (this.xPos + btnWidth), this.yPos);
        btns[2] = new CombatMenuBtn("Run Away", btnWidth, btnHeight, (this.xPos + (btnWidth / 2)), this.yPos + btnHeight);
    } //initBtns



    public void keyPressed(KeyEvent e, Combat combat) {
        switch (e.getKeyCode()) {
            case Constants.KeyboardConstants.ENTER:
                if (selectedIndex == 0) {
                    combat.getActionBar().updateButtons('a', combat.getCurrentTurn());
                    combat.setCombatState('a');
                } else if (selectedIndex == 1) {
                    combat.getActionBar().updateButtons('p', combat.getCurrentTurn());
                    combat.setCombatState('p');
                } else if (selectedIndex == 2) {
                    combat.setCombatState('r');
                } //if
                break;
        } //switch
    } //keyPressed

    public void mouseMoved(int x, int y) {
        for (int i = 0; i < btns.length; i++) {
            if (btns[i].getBounds().contains(x, y)) {
                updateSelection(i);
            } //if
        } //for
    } //mouseMoved

    public void mouseClicked(int x, int y, Combat combat) {
        if (btns[0].getBounds().contains(x, y)) {
            combat.getActionBar().updateButtons('a', combat.getCurrentTurn());
            combat.setCombatState('a');
        } else if (btns[1].getBounds().contains(x, y)) {
            combat.getActionBar().updateButtons('p', combat.getCurrentTurn());
            combat.setCombatState('p');
        } else if (btns[2].getBounds().contains(x, y)) {
            combat.setCombatState('r');
        } //if
    } //mouseClicked


    protected void updateBtnBounds(int y) {
        btns[0].setYPos(y);
        btns[1].setYPos(y);
        btns[2].setYPos(y + btns[2].getHeight());

        for (int i = 0; i < btns.length; i++) {
            btns[i].getBounds().setLocation(btns[i].getX(), btns[i].getYPos());
        } //for
    } //updateBounds

} //SelectionBar