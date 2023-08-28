package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import ui.bars.character_creation.ClassSelectBar;
import ui.bars.character_creation.RaceSelectBar;
import utilz.Constants;
import utilz.Enums;

public class CharacterCreation implements GameStateInterface {
    private RaceSelectBar raceSelectMenu;
    private ClassSelectBar classSelectMenu;

    public CharacterCreation() {
        raceSelectMenu = new RaceSelectBar(1180, 900, 50, 50);
        classSelectMenu = new ClassSelectBar(1180, 900, 50, 50);
    }

    public void render(Graphics g) {
        switch(Enums.CharacterCreationStates.State) {
            case RACE_SELECT:
                raceSelectMenu.draw(g);
                break;
            case CLASS_SELECT:
                classSelectMenu.draw(g);
                break;
            case BACKGROUND_SELECT:
                break;
        }
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
                break;
        }
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
                break;
        }
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
                break;
        }
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
                break;
        }
    }
    
}
