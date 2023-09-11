package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import render.GamePanel;
import utilz.HelperMethods;

public class QuestJournal implements GameStateInterface {

    private BufferedImage journal;
    private int width, height, xPos, yPos;

    public QuestJournal() {
        this.journal = HelperMethods.LoadImage("QuestJournal.png");
        this.width = HelperMethods.calcX(GamePanel.SCREEN_WIDTH - 150);
        this.height = HelperMethods.calcY(GamePanel.SCREEN_HEIGHT - 150);
        this.xPos = HelperMethods.calcX(75);
        this.yPos = HelperMethods.calcY(75);
    }

    public void render(Graphics g) {
        g.drawImage(journal, xPos, yPos, width, height, null);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    public void mouseWheelMoved(int wheelRotation) {
    }
    
}
