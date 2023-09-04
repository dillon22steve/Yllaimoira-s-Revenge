package location;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import render.GamePanel;
import utilz.HelperMethods;
import utilz.constants.TileConstants;

public class Location {

    private BufferedImage map;
    private BufferedImage locImg;
    private int xPosWorldMap, yPosWorldMap;
    private String name;
    private Rectangle bounds;
    private int[][] locData;

    
    public Location(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap) {
        this.map = HelperMethods.LoadImage(mapFileName);
        this.locImg = locImg;
        this.locData = new int[locImg.getHeight()][locImg.getWidth()];
        this.name = name;
        this.xPosWorldMap = xPosWorldMap;
        this.yPosWorldMap = yPosWorldMap;
        this.bounds = new Rectangle(xPosWorldMap, yPosWorldMap, 50, 50);

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
            
        } //switch
    } //loadCharacters

    private void loadTileData(int red, int x, int y) {
        locData[y][x] = red;
    } //loadTileData



    public void draw(Graphics g) {
        for (int j = 0; j < locData.length; j++) {
            for (int i = 0; i < locData[0].length; i++) {
                int artIndex = locData[j][i];
                int x = GamePanel.TILE_SIZE * i;
                int y = GamePanel.TILE_SIZE * j;

                if (artIndex < 12) {
                    g.drawImage(TileConstants.IMG.ART[artIndex], x, y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
                } else {
                    //System.out.println(artIndex + "at x: " + i + " and y: " + j);
                }
            } //for
        } //for
    } //draw


    public void drawMap(Graphics g) {
        g.drawImage(map, 0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT, null);
    } //drawMap



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
}
