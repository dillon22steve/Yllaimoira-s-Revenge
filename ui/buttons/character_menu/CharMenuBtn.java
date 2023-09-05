package ui.buttons.character_menu;

import utilz.constants.Constants;

import java.awt.Color;
import java.awt.Graphics;

import ui.buttons.Button;

public class CharMenuBtn extends Button {

    private boolean isSelected = false;
    private char selectDirection;
    private String selectString;
    private int selectionX, selectionY;

    public CharMenuBtn(String txt, int width, int height, int xPos, int yPos, char selectDirection) {
        super(txt, width, height, xPos, yPos);
        this.selectDirection = selectDirection;
        determineSelectString();
    } //constructor

    private void determineSelectString() {
        switch(selectDirection) {
            case 0:
                selectString = ">";
                selectionX = (this.xPos - 10);
                selectionY = (this.yPos + height / 2);
                break;
            case 1:
                selectString = "<---";
                selectionX = this.xPos - 50;
                selectionY = (this.yPos + height / 2);
                break;
            case 2:
                selectString = "--->";
                selectionX = this.xPos + width + 10;
                selectionY = (this.yPos + height / 2);
                break;
            case 3:
                selectString = ">";
                selectionX = this.xPos - 10;
                selectionY = (this.yPos + height / 2);
                break;
        }
    }


    public void draw(Graphics g) {
        drawBody(g);
        drawText(g);
    } //draw


    private void drawBody(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(xPos, yPos, width, height);
    } //drawBody


    private void drawText(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(Constants.Fonts.PAUSE_MENU_BTN_FONT);
        g.drawString(txt, xPos, (yPos + height / 2));

        if (isSelected) {
            g.drawString(selectString, selectionX, selectionY);
        } //if
    } //drawText


    public boolean isSelected() {
        return this.isSelected;
    } //isSelected
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    } //setSelected
    
} //CharMenuBtn
