package ui.buttons.character_menu;

import utilz.constants.Constants;

import java.awt.Color;
import java.awt.Graphics;

import ui.buttons.Button;

public class CharMenuBtn extends Button {

    private boolean isSelected = false;

    public CharMenuBtn(String txt, int width, int height, int xPos, int yPos) {
        super(txt, width, height, xPos, yPos);
    } //constructor


    public void draw(Graphics g) {
        drawText(g);
    } //draw


    private void drawText(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(Constants.Fonts.PAUSE_MENU_BTN_FONT);
        g.drawString(txt, xPos, (yPos + height / 2));

        if (isSelected) {
            g.drawString(">", xPos - 15, (yPos + height / 2));
        } //if
    } //drawText


    public boolean isSelected() {
        return this.isSelected;
    } //isSelected
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    } //setSelected
    
} //CharMenuBtn
