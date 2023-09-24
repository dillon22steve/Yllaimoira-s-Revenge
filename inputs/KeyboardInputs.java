package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestate.GameStates;
import render.Game;

public class KeyboardInputs implements KeyListener {

    private Game game;

    public KeyboardInputs(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(GameStates.GameState) {
            case MAINMENU:
                game.getMainMenu().keyPressed(e);
                break;
            case PLAYING:
                game.getPlaying().keyPressed(e);
                break;
            case CHARACTER_CREATION:
                game.getCharacterCreation().keyPressed(e);
                break;
            case CHARACTER_MENU:
                game.getCharacterMenu().keyPressed(e);
                break;
            case PAUSE_MENU:
                game.getPauseMenu().keyPressed(e);
                break;
            case MAP:
                game.getMap().keyPressed(e);
                break;
            case QUEST_JOURNAL:
                game.getQuestJournal().keyPressed(e);
                break;
            case COMBAT:
                game.getCombat().keyPressed(e);
                break;
            case DIALOGUE:
                game.getDialogueMenu().keyPressed(e);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.getPlaying().keyReleased(e);
    }
}