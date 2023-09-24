package location;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import characters.playable.Player;
import render.GamePanel;
import utilz.HelperMethods;
import utilz.constants.TileConstants;

public class Location {

    private BufferedImage map;
    private BufferedImage locImg;
    private int xPosWorldMap, yPosWorldMap;

    private int playerX, playerY;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private double movementSpeedX = 1.3;
    private double movementSpeedY = 1.0;

    private int maxWidth, maxHeight;
    private int xLvlOffset, yLvlOffset;
    private int leftBorder, rightBorder, btmBorder, topBorder;
    private int tilesWide, tilesHigh;
    private int maxTilesOffsetX, maxTilesOffsetY;
    private int maxOffsetX, maxOffsetY;

    private String name;
    private Rectangle bounds;
    private int[][] locData;

    
    public Location(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap,
        int width, int height) {

        this.map = HelperMethods.LoadImage(mapFileName);
        this.locImg = locImg;
        this.locData = new int[locImg.getHeight()][locImg.getWidth()];
        this.name = name;
        this.xPosWorldMap = xPosWorldMap;
        this.yPosWorldMap = yPosWorldMap;
        this.playerX = 0;
        this.playerY = 0;
        this.bounds = new Rectangle(xPosWorldMap, yPosWorldMap, width, height);

        loadLocation();
    }



    private void loadLocation() {
        for (int y = 0; y < locImg.getHeight(); y++) {
            for (int x = 0; x < locImg.getWidth(); x++) {
                Color c = new Color(locImg.getRGB(x, y));
                int red = c.getRed();
                //int blue = c.getBlue();
                //int green = c.getGreen();

                loadTileData(red, x, y);
                //loadCharacters(green, x, y);
                //loadObjects(blue, x, y);
            } //for
        } //for
    } //loadLocation

    private void loadObjects(int blue, int x, int y) {
        switch(blue) {

        } //switch
    } //loadObjects

    private void loadCharacters(int green, int x, int y) {
        switch(green) {
            case 0:
                playerX = x;
                playerY = y;
                break;
        } //switch
    } //loadCharacters

    private void loadTileData(int red, int x, int y) {
        locData[y][x] = red;
    } //loadTileData


    public void update() {
        if (left && !right) {
            playerX -= movementSpeedX;
            if (!canMove()) {
                playerX += movementSpeedX;
            } //if
        } else if (right && !left) {
            playerX += movementSpeedX;
            if (!canMove()) {
                playerX -= movementSpeedX;
            } //if
        } else if (down && !up) {
            playerY += movementSpeedY;
            if (!canMove()) {
                playerY -= movementSpeedY;
            } //if
        } else if (up && !down) {
            playerY -= movementSpeedY;
            if (!canMove()) {
                playerY += movementSpeedY;
            } //if
        } //if
        checkCloseToBorder();
    } //update

    private boolean canMove() {
        if (playerX >= maxWidth || playerX < 0) {
            return false;
        } else if (locData[playerY / 64][playerX / 64] != TileConstants.ID.GRASS &&
            locData[playerY / 64][playerX / 64] != TileConstants.ID.COBBLESTONE) {
            return false;
        } else {
            return true;
        } //if
    } //canMove

    private void checkCloseToBorder() {
        int differenceX = playerX - xLvlOffset;
        if (differenceX > rightBorder) {
            xLvlOffset += (differenceX - rightBorder);
        } else if (differenceX < leftBorder) {
            xLvlOffset += (differenceX - leftBorder);
        } //if

        if (xLvlOffset > maxOffsetX) {
            xLvlOffset = maxOffsetX;
        } else if (xLvlOffset < 0) {
            xLvlOffset = 0;
        } //if


        int differenceY = playerY - yLvlOffset;
        if (differenceY > btmBorder) {
            yLvlOffset += (differenceY - btmBorder);
        } else if (differenceY < topBorder) {
            yLvlOffset += (differenceY - topBorder);
        } //if

        if (yLvlOffset > maxOffsetY) {
            yLvlOffset = maxOffsetY;
        } else if (yLvlOffset < 0) {
            yLvlOffset = 0;
        } //if
    } //checkCloseToBorder



    public void draw(Graphics g, Player player) {
        for (int j = 0; j < locData.length; j++) {
            for (int i = 0; i < locData[0].length; i++) {
                int artIndex = locData[j][i];
                int x = GamePanel.TILE_SIZE * i;
                int y = GamePanel.TILE_SIZE * j;

                if (artIndex < TileConstants.IMG.ART.length) {
                    g.drawImage(TileConstants.IMG.ART[artIndex], (x - xLvlOffset), (y - yLvlOffset), GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
                } else {
                    //System.out.println(artIndex + "at x: " + i + " and y: " + j);
                } //if
            } //for
        } //for
        g.drawImage(player.getImg(), (playerX - xLvlOffset), (playerY - yLvlOffset), player.getImgSize(), player.getImgSize(), null);
    } //draw


    public void drawMap(Graphics g) {
        g.drawImage(map, 0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT, null);
    } //drawMap



    public void calcOffsetsAndBorders() {
        this.tilesWide = locData[0].length;
        this.tilesHigh = locData.length;

        this.maxWidth = tilesWide * GamePanel.TILE_SIZE;
        this.maxHeight = tilesHigh * GamePanel.TILE_SIZE;

        this.maxTilesOffsetX = tilesWide - GamePanel.TILES_WIDE;
        this.maxOffsetX = maxTilesOffsetX * GamePanel.TILE_SIZE;
        this.maxTilesOffsetY = tilesHigh - GamePanel.TILES_HIGH;
        this.maxOffsetY = maxTilesOffsetY * GamePanel.TILE_SIZE;

        this.leftBorder = (int)(0.2 * GamePanel.SCREEN_WIDTH);
        this.rightBorder = (int)(0.8 * GamePanel.SCREEN_WIDTH);
        this.topBorder = (int)(0.2 * GamePanel.SCREEN_HEIGHT);
        this.btmBorder = (int)(0.8 * GamePanel.SCREEN_HEIGHT);
    } //calcMaxWidth


    public int getX() {
        return this.xPosWorldMap;
    } //getX
    public int getY() {
        return this.yPosWorldMap;
    } //getY
    public String getName() {
        return this.name;
    } //getName
    public Rectangle getBounds() {
        return this.bounds;
    } //getBounds
    public void setLeft(boolean isMoving) {
        this.left = isMoving;
    } //setLeft
    public void setRight(boolean isMoving) {
        this.right = isMoving;
    } //setRight
    public void setUp(boolean isMoving) {
        this.up = isMoving;
    } //setUp
    public void setDown(boolean isMoving) {
        this.down = isMoving;
    } //setDown
}
