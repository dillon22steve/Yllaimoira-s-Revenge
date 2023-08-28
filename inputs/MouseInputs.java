package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import gamestate.GameStates;
import gamestate.GameStates.*;
import render.Game;

public class MouseInputs implements MouseListener, MouseMotionListener, MouseWheelListener {
    private Game game;


    public MouseInputs(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(GameStates.GameState) {
            case MAINMENU:
                game.getMainMenu().mouseClicked(e.getX(), e.getY());
                break;
            case PLAYING:
                game.getPlaying().mouseClicked(e.getX(), e.getY());
                break;
            case CHARACTER_CREATION:
                game.getCharacterCreation().mouseClicked(e.getX(), e.getY());
                break;
            case CHARACTER_MENU:
                game.getCharacterMenu().mouseClicked(e.getX(), e.getY());
                break;
            case PAUSE_MENU:
                game.getPauseMenu().mouseClicked(e.getX(), e.getY());
                break;
            case MAP:
                game.getMap().mouseClicked(e.getX(), e.getY());
                break;
            case QUEST_JOURNAL:
                game.getQuestJournal().mouseClicked(e.getX(), e.getY());
                break;
            case COMBAT:
                game.getCombat().mouseClicked(e.getX(), e.getY());
                break;
            case DIALOGUE:
                game.getDialogueMenu().mouseClicked(e.getX(), e.getY());
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(GameStates.GameState) {
            case MAINMENU:
                game.getMainMenu().MousePressed(e.getX(), e.getY());
                break;
            case PLAYING:
                game.getPlaying().mouseMoved(e.getX(), e.getY());
                break;
            case CHARACTER_CREATION:
                game.getCharacterCreation().mouseMoved(e.getX(), e.getY());
                break;
            case CHARACTER_MENU:
                game.getCharacterMenu().mouseMoved(e.getX(), e.getY());
                break;
            case PAUSE_MENU:
                game.getPauseMenu().mouseMoved(e.getX(), e.getY());
                break;
            case MAP:
                game.getMap().mouseMoved(e.getX(), e.getY());
                break;
            case QUEST_JOURNAL:
                game.getQuestJournal().mouseMoved(e.getX(), e.getY());
                break;
            case COMBAT:
                game.getCombat().mouseMoved(e.getX(), e.getY());
                break;
            case DIALOGUE:
                game.getDialogueMenu().mouseMoved(e.getX(), e.getY());
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch(GameStates.GameState) {
            case MAINMENU:
                game.getMainMenu().mouseMoved(e.getX(), e.getY());
                break;
            case PLAYING:
                game.getPlaying().mouseMoved(e.getX(), e.getY());
                break;
            case CHARACTER_CREATION:
                game.getCharacterCreation().mouseMoved(e.getX(), e.getY());
                break;
            case CHARACTER_MENU:
                game.getCharacterMenu().mouseMoved(e.getX(), e.getY());
                break;
            case PAUSE_MENU:
                game.getPauseMenu().mouseMoved(e.getX(), e.getY());
                break;
            case MAP:
                game.getMap().mouseMoved(e.getX(), e.getY());
                break;
            case QUEST_JOURNAL:
                game.getQuestJournal().mouseMoved(e.getX(), e.getY());
                break;
            case COMBAT:
                game.getCombat().mouseMoved(e.getX(), e.getY());
                break;
            case DIALOGUE:
                game.getDialogueMenu().mouseMoved(e.getX(), e.getY());
                break;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        switch(GameStates.GameState) {
            case MAINMENU:
                game.getMainMenu().mouseWheelMoved(e.getWheelRotation());
                break;
            case PLAYING:
                game.getPlaying().mouseWheelMoved(e.getWheelRotation());
                break;
            case CHARACTER_CREATION:
                game.getCharacterCreation().mouseWheelMoved(e.getWheelRotation());
                break;
            case CHARACTER_MENU:
                game.getCharacterMenu().mouseWheelMoved(e.getWheelRotation());
                break;
            case PAUSE_MENU:
                game.getPauseMenu().mouseWheelMoved(e.getWheelRotation());
                break;
            case MAP:
                game.getMap().mouseWheelMoved(e.getWheelRotation());
                break;
            case QUEST_JOURNAL:
                game.getQuestJournal().mouseWheelMoved(e.getWheelRotation());
                break;
            case COMBAT:
                game.getCombat().mouseWheelMoved(e.getWheelRotation());
                break;
            case DIALOGUE:
                game.getDialogueMenu().mouseWheelMoved(e.getWheelRotation());
                break;
        }
    }
    
}
