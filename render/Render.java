package render;

import java.awt.Graphics;

public class Render {
    private Game game;

    public Render(Game game) {
        this.game = game;
    } //constructor
    
    
    public void render(Graphics g) {
        switch(gamestate.GameStates.GameState) {
            case MAINMENU:
                game.getMainMenu().render(g);
                break;
            case PLAYING:
                game.getPlaying().render(g);
                break;
            case CHARACTER_CREATION:
                game.getCharacterCreation().render(g);
                break;
            case CHARACTER_MENU:
                game.getPlaying().render(g);
                game.getCharacterMenu().render(g);
                break;
            case PAUSE_MENU:
                game.getPauseMenu().render(g);
                break;
            case MAP:
                game.getMap().render(g);
                break;
            case COMBAT:
                game.getCombat().render(g);
                break;
            case QUEST_JOURNAL:
                game.getQuestJournal().render(g);
                break;
            case DIALOGUE:
                game.getDialogueMenu().render(g);
                break;
        } //switch
    } //render
} //Render