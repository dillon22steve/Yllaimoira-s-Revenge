package gamestate;

public enum GameStates {
    MAINMENU,
    CHARACTER_CREATION,
    PLAYING,
    MAP,
    CHARACTER_MENU,
    PAUSE_MENU,
    COMBAT,
    DIALOGUE, 
    QUEST_JOURNAL;

    public static GameStates GameState = MAINMENU;

    public void setGameState(GameStates GameState) {
        GameStates.GameState = GameState;
    }
}