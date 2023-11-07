package ui.buttons;

import java.awt.Color;
import java.awt.Graphics;

import utilz.HelperMethods;
import utilz.constants.Constants;

public class CombatMenuBtn extends Button {

    private boolean isSelected = false;

    public CombatMenuBtn(String txt, int width, int height, int xPos, int yPos) {
        super(txt, width, height, xPos, yPos);
    } //constructor


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(Constants.Fonts.PAUSE_MENU_BTN_FONT);
        int textX = this.xPos + width / 4;
        int textY = (yPos + height / 2);
        g.drawString(txt, textX, textY);
        if (isSelected) {
            g.drawString(">", (textX - 10), textY);
        } //if
    } //draw


    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    } //setIsSelected

} //CombatMenuBtn