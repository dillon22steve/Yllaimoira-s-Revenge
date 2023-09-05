package ui.buttons.character_menu;

import java.awt.Graphics;

import ui.buttons.Button;


public class LevelUpBtn extends Button {

    private boolean isSelected;

    public LevelUpBtn(String txt, int width, int height, int xPos, int yPos) {
        super(txt, width, height, xPos, yPos);
    } //constructor


    public void draw(Graphics g) {
        drawBody(g);
        drawText(g);
    } //draw

    private void drawBody(Graphics g) {
    } //drawBody

    private void drawText(Graphics g) {
    } //drawText
    
} //LevelUpBtn
