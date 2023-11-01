package location;

import java.awt.Rectangle;
import render.GamePanel;

public class Door {

    private Rectangle bounds;
    private Location locationIn, prevLocation;

    public Door(int xPos, int yPos, Location locationIn, Location prevLocation) {
        this.locationIn = locationIn;
        this.prevLocation = prevLocation;
        initBounds(xPos, yPos);
    } //constructor

    private void initBounds(int xPos, int yPos) {
        this.bounds = new Rectangle(xPos, yPos, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
    } //initBounds


    public Rectangle getBounds() {
        return this.bounds;
    } //getBounds
    public Location getLocationIn() {
        return this.locationIn;
    } //getLocationIn
    public Location getPrevLocation() {
        return this.prevLocation;
    } //getPrevLocation

} //Door
