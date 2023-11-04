package ui.bars.combat_menu;

import java.awt.Color;
import java.awt.Graphics;

public class CombatMenuBar extends ButtonBar {

    protected CombatMenuBtn[] btns;
    
    public CombatMenuBar(int width, int height, int xPos, int yPos) {
        super(HelperMethods.calcX(width), HelperMethods.calcY(height), HelperMethods.calcX(xPos), HelperMethods.calcY(yPos));
    } //constructor


    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, width, height);
        drawButtons(g);
    } //draw

    public void drawButtons(Graphics g){
        for (int i = 0; i < btns.length; i++) {
            btns[i].draw(g);
        } //for
    } //drawButtons


    public void setHeight(int height) {
        this.height = height;
    } //setHeight
    public void setYPos(int yPos) {
        this.yPos = yPos;
    } //setYPos

} //CombatMenuBar
