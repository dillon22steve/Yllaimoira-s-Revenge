package location;

import java.util.ArrayList;

import characters.playable.Player;
import characters.playable.enemies.Enemy;
import gamestate.GameStates;
import gamestate.Playing;
import render.GamePanel;
import utilz.constants.character_constants.EnemyConstants;

import java.lang.Math;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Dungeon extends Enterable {

    private ArrayList<Door> doors;
    private ArrayList<Enemy> enemies;
    private int numEnemies;
    private long lastRoll;
    private long now;

    public Dungeon(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap,
        int width, int height, Location cityIn, int doorLoc) {
        super(mapFileName, locImg, name, xPosWorldMap, yPosWorldMap, width, height, cityIn, doorLoc);
        enemies = new ArrayList<Enemy>();
        for (int i = 0; i < 5; i++) enemies.add(EnemyConstants.testEnemy);
        numEnemies = enemies.size();
        lastRoll = System.nanoTime();
    } //constructor


    @Override
    public void draw(Graphics g, Player player) {
        int size = GamePanel.TILE_SIZE;
        for (int i = 0; i < imgs.length; i++) {
            for (int j = 0; j < imgs[i].length; j++) {
                int x = GamePanel.TILE_SIZE * j;
                int y = GamePanel.TILE_SIZE * i;
                g.drawImage(imgs[i][j], (x - xLvlOffset), (y - yLvlOffset), size, size, null);
            } //for
        } //for
        
        g.drawImage(player.getImg(), (playerX - xLvlOffset), (playerY - yLvlOffset), player.getImgSize(), player.getImgSize(), null);
    } //draw


    @Override
    public void update(Playing playing) {
        movePlayer(playing);
        now = System.nanoTime();
        if ((now - lastRoll) >= 1_000_000_000.0) {
            lastRoll = now;

            //Randomly generates a number and if that number falls below the number of enemies in
            //the dungeon, the game will switch to the combat state and set the state's current
            //enemy to the enemy at the random index in the ArrayList.
            int rand = (int)((Math.random() * (50 + numEnemies)));
            if (rand < numEnemies) {
                playing.getGame().getCombat().initializeCombat(enemies.get(rand));
                GameStates.GameState = GameStates.COMBAT;
            } //if
        } //if
    } //update


    private void movePlayer(Playing playing) {
        if (left && !right) {
            if (canMove((int)(playerX - movementSpeedX), playerY)) {
                playerX -= movementSpeedX;
            } //if
        } else if (right && !left) {
            if (canMove((int)(playerX + movementSpeedX), playerY)) {
                playerX += movementSpeedX;
            } //if
        } else if (down && !up) {
            if (canMove(playerX, (int)(playerY + movementSpeedY))) {
                playerY += movementSpeedY;
            } //if
        } else if (up && !down) {
            if (canMove(playerX, (int)(playerY - movementSpeedY))) {
                playerY -= movementSpeedY;
            } //if
        } //if
        checkCloseToBorder();

        if (playerX >= doorLocX && (playerX <= doorLocX + GamePanel.TILE_SIZE) && 
            playerY >= doorLocY && (playerY <= doorLocY + GamePanel.TILE_SIZE)) {
                //This is going to change the location back to the city if the user enters the tile
                //that holds the door to the building.
                playing.setCurrLocation(cityIn);
        } //if
    } //update

    @Override
    protected boolean canMove(int x, int y) {
        if (x >= maxWidth || x < 0 || y >= maxHeight || y < 0) {
            return false;
        } else {
            return true;
        } //if
    } //canMove
    
} //Dungeon
