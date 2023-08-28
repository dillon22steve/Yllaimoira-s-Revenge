package ui.bars.character_creation;

import java.awt.Graphics;

import ui.buttons.CharCreatBtn;

public class BackgroundSelectBar extends CharacterCreationBar {
    CharCreatBtn[] backgrounds = {
        //new CharCreatBtn();
    };

    public BackgroundSelectBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        super.btns = backgrounds;  
    }

    public void draw(Graphics g) {
        drawButtons(g);
        drawBackgroundDesc(g, selection);
    }

    private void drawBackgroundDesc(Graphics g, int selection) {
        
    }
    
}
