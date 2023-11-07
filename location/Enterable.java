package location;

import java.awt.image.BufferedImage;
import render.GamePanel;


public class Enterable extends Location {

    protected Door mainDoor;
    protected BufferedImage[][] imgs;
    protected Location cityIn;
    protected int doorLocX, doorLocY;
    
    public Enterable (String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap,
        int width, int height, Location cityIn, int doorLoc) {
        super(mapFileName, locImg, name, xPosWorldMap, yPosWorldMap, width, height);
        this.isInBuilding = true;
        this.cityIn = cityIn;
        loadImgArr();
        this.doorLocX = doorLoc * GamePanel.TILE_SIZE;
        this.doorLocY = (imgs.length - 1) * GamePanel.TILE_SIZE;
        calcOffsetsAndBorders();
    } //constructor



    protected void loadImgArr() {
        int size = GamePanel.TILE_SIZE;
        int width = locImg.getWidth() / size;
        int height = locImg.getHeight() / size;
        imgs = new BufferedImage[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                imgs[i][j] = locImg.getSubimage(j * size, i * size, size, size);
            } //for
        } //for
    } //loadImgArr



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

} //Enterable
