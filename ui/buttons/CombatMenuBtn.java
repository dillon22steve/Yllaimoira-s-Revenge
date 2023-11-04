package ui.buttons;

import java.awt.Color;
import java.awt.Graphics;

public class CombatMenuBtn extends Button {

    private boolean isSelected = false;

    public CombatMenuBtn(String txt, int width, int height, int xPos, int yPos) {
        super(txt, width, height, xPos, yPos);
    } //constructor


    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        int textX = (xPos + width / 3);
        int textY = (yPos + height / 2);
        g.drawString(txt, textX, textY);
        if (isSelected) {
            g.drawString(">", (textX - 10), (yPos + height / 2));
        } //if
    } //draw
    
} //CombatMenuBtn