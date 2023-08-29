package ui.buttons;

import java.awt.Color;
import java.awt.Graphics;

import utilz.constants.Constants;

public class PauseMenuButton extends Button {

    private boolean isSelected = false;

    public PauseMenuButton(String txt, int width, int height, int xPos, int yPos) {
        super(txt, width, height, xPos, yPos);
        //TODO Auto-generated constructor stub
    }

    public void draw(Graphics g) {
        drawBody(g);
        drawText(g);
    }


    private void drawBody(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(xPos, yPos, width, height);
    }


    private void drawText(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(Constants.Fonts.PAUSE_MENU_BTN_FONT);
        g.drawString(txt, xPos, yPos);
    }


    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    public boolean isSelected() {
        return this.isSelected;
    }
    
}
