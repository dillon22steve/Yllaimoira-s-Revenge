package location;

import java.awt.Color;
import java.awt.image.BufferedImage;

import render.GamePanel;

public class City extends Location {

    public City(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap, int width, int height) {
        super(mapFileName, locImg, name, xPosWorldMap, yPosWorldMap, width, height);
        this.isInBuilding = false;
        loadLocation();
    } //constructor


    private void loadLocation() {
        for (int y = 0; y < locImg.getHeight(); y++) {
            for (int x = 0; x < locImg.getWidth(); x++) {
                Color c = new Color(locImg.getRGB(x, y));
                int red = c.getRed();
                //int blue = c.getBlue();
                int green = c.getGreen();

                loadTileData(red, x, y);
                loadCharacters(green, x, y);
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

} //City
