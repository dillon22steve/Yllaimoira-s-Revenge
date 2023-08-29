package ui.bars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import ui.buttons.Button;
import ui.buttons.PauseMenuButton;
import utilz.Constants;

public class PauseMenuBar extends ButtonBar {
    private PauseMenuButton resumeBtn, saveBtn, loadBtn, quitBtn;
    private static final int RESUME = 0;
    private static final int SAVE = 1;
    private static final int LOAD = 2;
    private static final int QUIT = 3;

    private int selectedBtn = 0;
    
    public PauseMenuBar(int width, int height, int xPos, int yPos) {
        super(width, height, xPos, yPos);
        initButtons();
    }

    private void initButtons() {
        int buttonWidth = (this.width / 3) * 2;
        int buttonHeight = (this.height / 6);
        int buttonX = (this.xPos + this.width/2 - buttonWidth/2);
        int buttonY = this.yPos + buttonHeight;
        int yOffset = (buttonHeight + buttonHeight / 10);

        resumeBtn = new PauseMenuButton("Resume", buttonWidth, buttonHeight, buttonX, buttonY);
        saveBtn = new PauseMenuButton("Save", buttonWidth, buttonHeight, buttonX, (buttonY + yOffset));
        loadBtn = new PauseMenuButton("Load", buttonWidth, buttonHeight, buttonX, (buttonY + yOffset*2));
        quitBtn = new PauseMenuButton("Quit", buttonWidth, buttonHeight, buttonX, (buttonY + yOffset*3));
    }

    public void draw(Graphics g) {
        drawBtns(g);
        drawTitle(g);
        drawBody(g);
    }
    private void drawBody(Graphics g) {
    }
    private void drawTitle(Graphics g) {
        g.setFont(Constants.Fonts.PAUSE_MENU_TITLE_FONT);
        g.setColor(Color.WHITE);
        g.drawString("GAME PAUSED", (this.xPos + this.width/20), (this.yPos + this.height/10));
    }
    private void drawBtns(Graphics g) {
        resumeBtn.draw(g);
        saveBtn.draw(g);
        loadBtn.draw(g);
        quitBtn.draw(g);
    }



    public void keyPressed(KeyEvent e) {
        resetSelected();
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.UP:
                if (selectedBtn == RESUME) {
                    selectedBtn = QUIT; quitBtn.setIsSelected(true);
                } else if (selectedBtn == SAVE) {
                    selectedBtn = RESUME; 
                    resumeBtn.setIsSelected(true);
                } else if (selectedBtn == LOAD) {
                    selectedBtn = SAVE; 
                    saveBtn.setIsSelected(true);
                } else if (selectedBtn == QUIT) {
                    selectedBtn = LOAD; 
                    loadBtn.setIsSelected(true);
                } //if
                break;
            case Constants.KeyboardConstants.DOWN:
                if (selectedBtn == RESUME) selectedBtn = SAVE;
                else if (selectedBtn == SAVE) selectedBtn = LOAD;
                else if (selectedBtn == LOAD) selectedBtn = QUIT;
                else if (selectedBtn == QUIT) selectedBtn = RESUME;
                break;
        } 
    }

    private void resetSelected() {
        resumeBtn.setIsSelected(false);
        saveBtn.setIsSelected(false);
        loadBtn.setIsSelected(false);
        quitBtn.setIsSelected(false);
    }


    public void mouseClicked(int x, int y) {
        checkBtnBounds(x, y);
    }

    public void mouseMoved(int x, int y) {
        checkBtnBounds(x, y);
    }

    public void mouseWheelMoved(int wheelRotation) {
        resetSelected();
        if (wheelRotation < 0) {
            if (selectedBtn > 0) {
                selectedBtn -= 1;
            } else if (selectedBtn == 0) {
                selectedBtn = 3;
            } //if
        } else {
            if (selectedBtn < 3) {
                selectedBtn += 1;
            } else if (selectedBtn == 3) {
                selectedBtn = 0;
            } //if
        } //if

        switch(selectedBtn) {
            case RESUME:
                resumeBtn.setIsSelected(true);
                break;
            case SAVE:
                saveBtn.setIsSelected(true);
                break;
            case LOAD:
                loadBtn.setIsSelected(true);
                break;
            case QUIT:
                quitBtn.setIsSelected(true);
                break;
        }
    }


    public void checkBtnBounds(int x, int y) {
        if ((resumeBtn.getBounds().contains(x, (y - 25))) ||
                (resumeBtn.getBounds().contains(x, (y + 25)))) {
                selectedBtn = RESUME;
                resumeBtn.setIsSelected(true);
        } else if ((saveBtn.getBounds().contains(x, (y - 25))) ||
                (saveBtn.getBounds().contains(x, (y + 25)))) {
                selectedBtn = QUIT;
                saveBtn.setIsSelected(true);
        } else if ((loadBtn.getBounds().contains(x, (y - 25))) ||
                (loadBtn.getBounds().contains(x, (y + 25)))) {
                selectedBtn = LOAD;
                loadBtn.setIsSelected(true);
        } else if ((quitBtn.getBounds().contains(x, (y - 25))) ||
                (resumeBtn.getBounds().contains(x, (y + 25)))) {
                selectedBtn = QUIT;
                quitBtn.setIsSelected(true);
        } else {
            return;
        }

        resetSelected();
    }
}
