package ui.buttons;

import java.awt.Color;
import java.awt.Graphics;

import utilz.Constants;

public class CharCreatBtn extends Button{
    String txt;

    public CharCreatBtn(String txt, int width, int height, int x, int y) {
        super(width, height, x, y);
        this.txt = txt;
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
        g.setFont(Constants.Fonts.CHAR_CREAT_BTN_FONT);
        g.drawString(txt, xPos, yPos);
    }
}
