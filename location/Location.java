package location;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Location {

    private BufferedImage map;
    private BufferedImage locImg;
    private int xPosWorldMap, yPosWorldMap;
    private String name;
    private Rectangle bounds;
    private int[][] locData;

    
    public Location(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap) {
        initMap(mapFileName);

        this.locImg = locImg;
        this.locData = new int[locImg.getWidth()][locImg.getHeight()];
        this.name = name;
        this.xPosWorldMap = xPosWorldMap;
        this.yPosWorldMap = yPosWorldMap;

        initBounds();
        loadLocation();
    }

    private void initBounds() {
        this.bounds = new Rectangle(xPosWorldMap, yPosWorldMap, 50, 50);
    }

    public void initMap(String mapFileName) {
        InputStream is = getClass().getResourceAsStream("/res/" + mapFileName);
		
		try {
			map = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
    }

    private void loadLocation() {
        for (int y = 0; y < locImg.getHeight(); y++) {
            for (int x = 0; x < locImg.getWidth(); x++) {
                Color c = new Color(locImg.getRGB(x, y));
                int red = c.getRed();
                int blue = c.getBlue();
                int green = c.getGreen();

                loadTileData(red, x, y);
                loadCharacters(green, x, y);
                loadObjects(blue, x, y);
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
        locData[x][y] = red;
    } //loadTileData



    public void draw(Graphics g) {
        
    }



    public int getX() {
        return this.xPosWorldMap;
    }
    public int getY() {
        return this.yPosWorldMap;
    }
    public String getName() {
        return this.name;
    }
    public Rectangle getBounds() {
        return this.bounds;
    }
}
