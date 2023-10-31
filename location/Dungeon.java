import java.util.ArrayList;
import gamestate.GameStates;
import java.lang.Math;

public class Dungeon extends Enterable {

    private ArrayList<Door> doors;
    private ArrayList<Enemy> enemies;
    private int numEnemies;
    private long lastRoll;
    private long now;

    public Dungeon(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap,
        int width, int height, Location cityIn, int doorLoc) {
        super(mapFileName, locImg, name, xPosWorldMap, yPosWorldMap, width, height, cityIn, doorLoc);
        lastRoll = System.nanoTime();
    } //constructor


    @Override
    public void update(Playing playing) {
        now = System.nanoTime();
        if ((now - lastRoll) >= 1_000_000_000.0) {
            lastRoll = now;

            //Randomly generates a number and if that number falls below the number of enemies in
            //the dungeon, the game will switch to the combat state and set the state's current
            //enemy to the enemy at the random index in the ArrayList.
            int rand = (int)((Math.random() * (50 + numEnemies)));
            if (rand < numEnemies) {
                GameStates.GameState = GameStates.COMBAT;
                playing.getGame().getCombat().setEnemy(enemies.get(rand));
            } //if
        } //if
    } //update
    
} //Dungeon
