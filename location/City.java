package location;

import java.awt.image.BufferedImage;

public class City extends Location {

    public City(String mapFileName, BufferedImage locImg, String name, int xPosWorldMap, int yPosWorldMap) {
        super(mapFileName, locImg, name, xPosWorldMap, yPosWorldMap);
    }
    
}
