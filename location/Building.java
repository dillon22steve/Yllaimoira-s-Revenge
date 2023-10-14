package location;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import characters.playable.Player;
import gamestate.Playing;
import render.GamePanel;

public class Building extends Location {

    private BufferedImage[][] imgs;
    private Location cityIn;
    private int doorLocX;
    private int doorLocY;

    public Building(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap,
            int width, int height, Location cityIn, int doorLoc) {

        super(mapFileName, locImg, name, xPosWorldMap, yPosWorldMap, width, height);
        this.cityIn = cityIn;
        this.doorLocX = doorLoc * GamePanel.TILE_SIZE;
        this.isInBuilding = true;
        this.loadImgArr();
        this.doorLocY = (imgs.length - 1) * GamePanel.TILE_SIZE;
        this.calcOffsetsAndBorders();
    } //Building


    private void loadImgArr() {
        int size = GamePanel.TILE_SIZE;
        int width = locImg.getWidth() / size;
        int height = locImg.getHeight() / size;
        imgs = new BufferedImage[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                imgs[i][j] = locImg.getSubimage(j * size, i * size, size, size);
            } //for
        } //for
    } //LoadImgArr


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


    @Override
    public void calcOffsetsAndBorders() {
        this.tilesWide = imgs[0].length;
        this.tilesHigh = imgs.length;

        this.maxWidth = tilesWide * GamePanel.TILE_SIZE;
        this.maxHeight = tilesHigh * GamePanel.TILE_SIZE;

        //If the number of tiles in the building surpasses the number of tiles on the screen,
        //Then the maxTilesOffset will be set to the number of tiles in the building minus
        //the number of tiles on the screen. Else, the max offset will be the number of tiles
        //in the building.
        if (tilesWide > GamePanel.TILES_WIDE) {
            this.maxTilesOffsetX = tilesWide - GamePanel.TILES_WIDE;
        } else {
            this.maxTilesOffsetX = tilesWide;
        } //if
        if (tilesHigh > GamePanel.TILES_HIGH) {
             this.maxTilesOffsetY = tilesHigh - GamePanel.TILES_HIGH;
        } else {
             this.maxTilesOffsetY = tilesHigh;
        } //if
        this.maxOffsetX = maxTilesOffsetX * GamePanel.TILE_SIZE;
        this.maxOffsetY = maxTilesOffsetY * GamePanel.TILE_SIZE;

        this.leftBorder = (int)(0.2 * GamePanel.SCREEN_WIDTH);
        this.rightBorder = (int)(0.8 * GamePanel.SCREEN_WIDTH);
        this.topBorder = (int)(0.2 * GamePanel.SCREEN_HEIGHT);
        this.btmBorder = (int)(0.8 * GamePanel.SCREEN_HEIGHT);
    } //calcOffsetsAndBorders



    public BufferedImage[][] getImgs() {
        return imgs;
    } //getImgs

    public Location getCityIn() {
        return cityIn;
    } //getCityIn

    public int getDoorLocX() {
        return doorLocX;
    } //getDoorLocX
    
    
} //Building
