package location;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import characters.playable.Player;
import gamestate.Playing;
import render.GamePanel;

public class Building extends Enterable {

    private int doorLocX;
    private int doorLocY;

    public Building(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap,
            int width, int height, Location cityIn, int doorLoc) {

        super(mapFileName, locImg, name, xPosWorldMap, yPosWorldMap, width, height, cityIn, doorLoc);
    } //Building


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
    
} //Building
