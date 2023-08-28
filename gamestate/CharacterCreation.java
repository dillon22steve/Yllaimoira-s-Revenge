package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import ui.bars.character_creation.BackgroundSelectBar;
import ui.bars.character_creation.ClassSelectBar;
import ui.bars.character_creation.RaceSelectBar;
import utilz.Enums;

public class CharacterCreation implements GameStateInterface {
    private RaceSelectBar raceSelectMenu;
    private ClassSelectBar classSelectMenu;
    private BackgroundSelectBar backgroundSelectMenu;

    public CharacterCreation() {
        raceSelectMenu = new RaceSelectBar(1180, 900, 50, 50);
        classSelectMenu = new ClassSelectBar(1180, 900, 50, 50);
        backgroundSelectMenu = new BackgroundSelectBar(1180, 900, 50, 50);
    } //constructor

    public void render(Graphics g) {
        switch(Enums.CharacterCreationStates.State) {
            case RACE_SELECT:
                raceSelectMenu.draw(g);
                break;
            case CLASS_SELECT:
                classSelectMenu.draw(g);
                break;
            case BACKGROUND_SELECT:
                backgroundSelectMenu.draw(g);
                break;
        } //switch
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(Enums.CharacterCreationStates.State) {
            case RACE_SELECT:
                raceSelectMenu.keyPressed(e);
                break;
            case CLASS_SELECT:
                classSelectMenu.keyPressed(e);
                break;
            case BACKGROUND_SELECT:
                backgroundSelectMenu.keyPressed(e);
                break;
        } //switch
    }

    @Override
    public void mouseClicked(int x, int y) {
        switch(Enums.CharacterCreationStates.State) {
            case RACE_SELECT:
                raceSelectMenu.mouseClicked(x, y);
                break;
            case CLASS_SELECT:
                classSelectMenu.mouseClicked(x, y);
                break;
            case BACKGROUND_SELECT:
                backgroundSelectMenu.mouseClicked(x, y);
                break;
        } //switch
    }

    @Override
    public void mouseMoved(int x, int y) {
        switch(Enums.CharacterCreationStates.State) {
            case RACE_SELECT:
                raceSelectMenu.mouseMoved(x, y);
                break;
            case CLASS_SELECT:
                classSelectMenu.mouseMoved(x, y);
                break;
            case BACKGROUND_SELECT:
                backgroundSelectMenu.mouseMoved(x, y);
                break;
        } //switch
    }

    public void mouseWheelMoved(int wheelRotation) {
        switch(Enums.CharacterCreationStates.State) {
            case RACE_SELECT:
                raceSelectMenu.mouseWheelMoved(wheelRotation);
                break;
            case CLASS_SELECT:
                classSelectMenu.mouseWheelMoved(wheelRotation);
                break;
            case BACKGROUND_SELECT:
                backgroundSelectMenu.mouseWheelMoved(wheelRotation);
                break;
        } //switch
    }
    
}
