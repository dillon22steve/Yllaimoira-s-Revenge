package ui.buttons;

import java.awt.Rectangle;

public class Button {
    int width, height, xPos, yPos;
    String txt;
    private Rectangle bounds;

    public Button(String txt, int width, int height, int xPos, int yPos) {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.txt = txt;

        initBounds();
    }

    private void initBounds() {
        this.bounds = new Rectangle(xPos, yPos, width, height);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public int getX() {
        return this.xPos;
    }
    public int getY() {
        return this.yPos;
    }
}
