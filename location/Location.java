package location;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Location {

    private BufferedImage map;
    private int xPosWorldMap, yPosWorldMap;
    private String name;
    private Rectangle bounds;

    
    public Location(String mapFileName, String name, int xPosWorldMap, int yPosWorldMap) {
        initMap(mapFileName);
        this.name = name;
        this.xPosWorldMap = xPosWorldMap;
        this.yPosWorldMap = yPosWorldMap;
        initBounds();
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
