package ui.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import utilz.Constants;

public class MainMenuBtn extends Button {
    static float opacity = 255;
    static float opacityUpdate = 1.2f;

    boolean mousePressed, mouseOver, isSelected;

    public MainMenuBtn(String txt, int width, int height, int xPos, int yPos) {
        super(txt, width, height, xPos, yPos);
    }


    public static void updateOpacity() {
        if (opacity < 35) {
            opacity = 35;
            opacityUpdate *= -1;
        } else if (opacity > 255) {
            opacity = 255;
            opacityUpdate *= -1;
        }

        opacity -= opacityUpdate;
    }



    public void draw(Graphics g) {
        drawBody(g);

        //drawBorder(g);
        
        drawText(g);
    }


    private void drawText(Graphics g) {
        if (isSelected) {
            g.setColor(new Color(255, 255, 255, (int)opacity));
        } else {
            g.setColor(Color.WHITE);
        }

        g.setFont(Constants.Fonts.MAIN_MENU_BTN_FONT);
        int w = g.getFontMetrics().stringWidth(txt);
        int h = g.getFontMetrics().getHeight();
        g.drawString(txt, (xPos - w/2 + width/2), (yPos + h/2 + height/2));
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(xPos, yPos, width, height);
        if(mousePressed) {
            g.drawRect(xPos + 1, yPos + 1, width - 2, height - 2);
            g.drawRect(xPos + 2, yPos + 2, width - 4, height - 4);
        } else {
            g.setColor(Color.white);
            g.drawRect(xPos, yPos, width, height);
        }
    }

    private void drawBody(Graphics g) {
        if(mouseOver) {
            g.setColor(Color.gray);
        } else {
            g.setColor(Color.white);
        }
    }




    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }
    public boolean isMouseOver() {
        return mouseOver;
    }


    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public boolean isMousePressed() {
        return this.mousePressed;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    public boolean isSelected() {
        return isSelected;
    }


    public void resetBooleans() {
        this.mouseOver = false;
        this.mousePressed = false;
    }
}
