package ui.bars.combat_menu;

import java.awt.event.KeyEvent;

import gamestate.Combat;
import ui.buttons.CombatMenuBtn;
import utilz.constants.Constants;

public class RunBar extends CombatMenuBar {

    public RunBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        initButtons();
    } //constructor

    private void initButtons() {
        btns = new CombatMenuBtn[3];
        int btnWidth = this.width / 2;
        int btnHeight = this.height / 2;
        btns[0] = new CombatMenuBtn("Yes", btnWidth, btnHeight, this.xPos, (this.yPos + btnHeight));
        btns[1] = new CombatMenuBtn("No", btnWidth, btnHeight, (this.xPos + btnWidth), (this.yPos + btnHeight));
        btns[2] = new CombatMenuBtn("Are you sure you want to run away?", this.width, btnHeight, this.xPos, this.yPos);
    } //initButtons


    @Override
    protected void updateBtnBounds(int y) {
        btns[0].setYPos(y + btns[0].getHeight());
        btns[1].setYPos(y + btns[1].getHeight());
        btns[2].setYPos(y);

        for (int i = 0; i < btns.length; i++) {
            btns[i].getBounds().setLocation(btns[i].getX(), btns[i].getYPos());
        } //for
    } //updateBtnBounds



    public void keyPressed(KeyEvent e, Combat combat) {
        switch (e.getKeyCode()) {
            case Constants.KeyboardConstants.ENTER:
                if (selectedIndex == 0) {
                    combat.rollToRunAway();
                } else if (selectedIndex == 1) {
                    combat.setCombatState('s');
                } //if
                break;
        } //switch
    } //keyPressed

    public void mouseClicked(int x, int y, Combat combat) {
        if (btns[0].getBounds().contains(x, y)) {
            combat.rollToRunAway();
        } else if (btns[1].getBounds().contains(x, y)) {
            combat.setCombatState('s');
        } //if
    } //mouseClicked

    public void mouseMoved(int x, int y, Combat combat) {
        if (x >= this.xPos && y >= this.yPos && y <= (this.yPos + this.height)) {
            if (btns[0].getBounds().contains(x, y)) {
                updateSelection(0);
            } else if (btns[1].getBounds().contains(x, y)) {
                updateSelection(1);
            } //if
        } //if
    } //mouseMoved
    
} //RunBar
