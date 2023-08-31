package map;

import java.awt.image.BufferedImage;

import render.GamePanel;
import utilz.HelperMethods;

public class Map {
    
    int mapCoord, mapWidth, mapHeight;
    int stringX, stringY;
    BufferedImage mapImg;

    public Map() {
        initMapSize();
    }

    private void initMapSize() {
        mapCoord = 0;
        mapWidth = GamePanel.SCREEN_WIDTH;
        mapHeight = GamePanel.SCREEN_HEIGHT;
        stringY = HelperMethods.calcY(925);
    }
}
