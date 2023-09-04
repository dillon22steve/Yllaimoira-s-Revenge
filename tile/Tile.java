package tile;

import java.awt.image.BufferedImage;

public class Tile {
    private int id;
    private BufferedImage img;
    private int xPos, yPos;

    public Tile(BufferedImage img, int id, int xPos, int yPos) {
        this.img = img;
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
    }



    public int getId() {
        return this.id;
    }
    public BufferedImage getImg() {
        return this.img;
    }
    public int getX() {
        return this.xPos;
    }
    public int getY() {
        return this.yPos;
    }
}
