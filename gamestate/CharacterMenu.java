package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import render.GamePanel;
import ui.bars.character_menu.CharacterMenuSelectionBar;
import utilz.Enums;


public class CharacterMenu implements GameStateInterface {

    private CharacterMenuSelectionBar selectionBar;

    public CharacterMenu() {
        this.selectionBar = new CharacterMenuSelectionBar(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT, 0, 0);
    } //CharacterMenu

    public void render(Graphics g) {
        switch(Enums.CharacterMenuStates.State) {
            case SELECTION:
                selectionBar.draw(g);
                break;
            case LEVEL_UP:
                break;
            case INVENTORY:
                break;
            case QUEST_JOURNAL:
                break;
        } //switch
    } //render

    @Override
    public void update() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(Enums.CharacterMenuStates.State) {
            case SELECTION:
                selectionBar.keyPressed(e);
                break;
            case LEVEL_UP:
                break;
            case INVENTORY:
                break;
            case QUEST_JOURNAL:
                break;
        } //switch
    }

    @Override
    public void mouseClicked(int x, int y) {
        switch(Enums.CharacterMenuStates.State) {
            case SELECTION:
                selectionBar.mouseClicked(x, y);
                break;
            case LEVEL_UP:
                break;
            case INVENTORY:
                break;
            case QUEST_JOURNAL:
                break;
        } //switch
    }

    @Override
    public void mouseMoved(int x, int y) {
        switch(Enums.CharacterMenuStates.State) {
            case SELECTION:
                selectionBar.mouseMoved(x, y);
                break;
            case LEVEL_UP:
                break;
            case INVENTORY:
                break;
            case QUEST_JOURNAL:
                break;
        } //switch
    }

    public void mouseWheelMoved(int wheelRotation) {
        switch(Enums.CharacterMenuStates.State) {
            case SELECTION:
                selectionBar.mouseWheelMoved(wheelRotation);
                break;
            case LEVEL_UP:
                break;
            case INVENTORY:
                break;
            case QUEST_JOURNAL:
                break;
        } //switch
    }
    
}
