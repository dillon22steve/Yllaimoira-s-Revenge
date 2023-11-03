package render;

import java.lang.Runnable;

import characters.playable.Player;
import render.*;
import gamestate.*;


public class Game implements Runnable {

    private GamePanel gamePanel;
    private GameFrame gameFrame;
    private Render render;
    private MainMenu mainMenu;
    private Playing playing;
    private CharacterCreation characterCreation;
    private PauseMenu pauseMenu;
    private Map map;
    private CharacterMenu characterMenu;
    private Combat combat;
    private QuestJournal questJournal;
    private Dialogue dialogueMenu;

    private Player player;

    private Thread gameThread;

    private final double FPS_SET = 120;
    private final double UPS_SET = 200;


    public Game() {
        initClasses();
    }

    public void initClasses() {
        this.gamePanel = new GamePanel(this);
        this.gameFrame = new GameFrame(gamePanel);
        this.render = new Render(this);
        this.mainMenu = new MainMenu(this);
        this.characterCreation = new CharacterCreation();
        this.pauseMenu = new PauseMenu();
        this.player = new Player("Steve", 100, 100, 1);
        this.playing = new Playing(this);
        this.map = new Map();
        this.characterMenu = new CharacterMenu();
        this.combat = new Combat(this);
        this.questJournal = new QuestJournal();
        this.dialogueMenu = new Dialogue();
    }


    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void updateGame() {
        switch(GameStates.GameState) {
            case MAINMENU:
                mainMenu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case CHARACTER_CREATION:
                break;
            case CHARACTER_MENU:
                break;
            case PAUSE_MENU:
                break;
            case MAP:
                break;
            case QUEST_JOURNAL:
                break;
            case COMBAT:
                break;
            case DIALOGUE:
                break;
        }
    }


    @Override
    public void run() {
        double timePerFrame = (1_000_000_000.0 / FPS_SET);
		double timePerUpdate = (1_000_000_000.0 / UPS_SET);
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long now = System.nanoTime();

        //long lastTimeCheck = 0;
        //int frames = 0;
        //int updates = 0;

        while(true) {
            now = System.nanoTime();

            if((now - lastFrame) >= timePerFrame) {
                lastFrame = now;
                gamePanel.repaint();
                //frames++;
            }

            if((now - lastUpdate) >= timePerUpdate) {
                lastUpdate = now;
                updateGame();
                //updates++;
            }

            /*
            if ( System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("frames: " + frames + " | updates: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
            */
        }
    }


    public GamePanel getGamePanel() {
        return this.gamePanel;
    }
    public Render getRender() {
        return this.render;
    }
    public MainMenu getMainMenu() {
        return this.mainMenu;
    }
    public Playing getPlaying() {
        return this.playing;
    }
    public CharacterCreation getCharacterCreation() {
        return this.characterCreation;
    }
    public CharacterMenu getCharacterMenu() {
        return this.characterMenu;
    }
    public PauseMenu getPauseMenu() {
        return this.pauseMenu;
    }
    public Map getMap() {
        return this.map;
    }
    public Combat getCombat() {
        return this.combat;
    }
    public QuestJournal getQuestJournal() {
        return this.questJournal;
    }
    public Dialogue getDialogueMenu() {
        return this.dialogueMenu;
    }
    public Player getPlayer() {
        return this.player;
    }
}
