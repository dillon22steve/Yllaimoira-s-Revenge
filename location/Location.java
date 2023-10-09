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

    protected boolean isInBuilding;

    private BufferedImage map;
    protected BufferedImage locImg;
    private int xPosWorldMap, yPosWorldMap;

    protected int playerX, playerY;
    protected boolean left = false;
    protected boolean right = false;
    protected boolean up = false;
    protected boolean down = false;

    protected double movementSpeedX = 1.3;
    protected double movementSpeedY = 1.0;

    protected int maxWidth, maxHeight;
    protected int xLvlOffset, yLvlOffset;
    protected int leftBorder, rightBorder, btmBorder, topBorder;
    protected int tilesWide, tilesHigh;
    protected int maxTilesOffsetX, maxTilesOffsetY;
    protected int maxOffsetX, maxOffsetY;

    private String name;
    private Rectangle bounds;
    protected int[][] locData;

    
    public Location(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap,
        int width, int height) {

        this.map = HelperMethods.LoadImage(mapFileName);
        this.locImg = locImg;
        this.locData = new int[locImg.getHeight()][locImg.getWidth()];
        this.name = name;
        this.xPosWorldMap = xPosWorldMap;
        this.yPosWorldMap = yPosWorldMap;
        this.bounds = new Rectangle(xPosWorldMap, yPosWorldMap, width, height);
    } //Constructor



    public void update() {
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
    } //update

    protected boolean canMove(int x, int y) {
        if (x >= maxWidth || x < 0 || y >= maxHeight || y < 0) {
            return false;
        } else {
            int tile = locData[y / GamePanel.TILE_SIZE][x / GamePanel.TILE_SIZE];

            //If the tile the player is trying to move to is not grass, cobblestone, or a plank,
            //it returns false. Otherwise, it returns true.
            if (tile != TileConstants.ID.GRASS && tile != TileConstants.ID.COBBLESTONE &&
                !(tile <= TileConstants.ID.PLANK_DOWN_LEFT && tile >= TileConstants.ID.PLANK_VERT)) {
                return false;
            } else {
                return true;
            } //if
        } //if
    } //canMove

    protected void checkCloseToBorder() {
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
    public int[][] getLocData() {
        return locData;
    } //getLocData
    public boolean isInBuilding() {
        return this.isInBuilding;
    } //isInBuilding
    public void setIsInBuilding(boolean isInBuilding) {
        this.isInBuilding = isInBuilding;
    } //setIsInBuilding
    public int getDoorLocX() {
        return 0;
    } //getDoorLocX
    public BufferedImage[][] getImgs() {
        return null;
    } //getImgs
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    } //setPlayerX
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    } //setPlayerY
    public int getPlayerY() {
        return this.playerY;
    } //getPlayerY
    public void setYLvlOffset(int yLvlOffset) {
        this.yLvlOffset = yLvlOffset;
    } //setYLvlOffset
    
} //Location
