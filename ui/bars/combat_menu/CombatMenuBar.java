package ui.bars.combat_menu;

import java.awt.Color;
import java.awt.Graphics;
import ui.buttons.CombatMenuBtn;
import ui.bars.ButtonBar;
import utilz.HelperMethods;

public class CombatMenuBar extends ButtonBar {

    protected CombatMenuBtn[] btns;
    protected int selectedIndex;
    
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


    protected void updateSelection(int newSelection) {
        btns[selectedIndex].setIsSelected(false);
        btns[newSelection].setIsSelected(true);
        selectedIndex = newSelection;
    } //updateSelection


    public void updateYPos(int y) {
        this.yPos = y;
        updateBtnBounds(y);
    } //updateYPos


    protected void updateBtnBounds(int y) {
        //This method that will be overridden by the child classes.
    } //updateBtnBounds


    public void setHeight(int height) {
        this.height = height;
    } //setHeight
    public int getHeight() {
        return this.height;
    } //getHeight
    public void setYPos(int yPos) {
        this.yPos = yPos;
    } //setYPos

} //CombatMenuBar
