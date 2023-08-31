package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import map.*;

public class Map implements GameStateInterface {

    public static final char WORLD_MAP = 0;
    public static final char LOCAL_MAP = 1;
    public static char CURRENT_MAP = WORLD_MAP;

    private WorldMap worldMap;
    private LocalMap localMap;

    public Map() {
        this.worldMap = new WorldMap();
        this.localMap = new LocalMap();
    }


    public void render(Graphics g) {
        if (CURRENT_MAP == WORLD_MAP) {
            worldMap.render(g);
        } else {
            localMap.render(g);
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(CURRENT_MAP) {
            case WORLD_MAP:
                worldMap.keyPressed(e);
                break;
            default:
                localMap.keyPressed(e);
                break;
        } //switch
    } //keyPressed

    @Override
    public void mouseClicked(int x, int y) {
        switch(CURRENT_MAP) {
            case WORLD_MAP:
                worldMap.mouseClicked(x, y);
                break;
            default:
                localMap.mouseClicked(x, y);
                break;
        } //switch
    } //mouseClicked

    @Override
    public void mouseMoved(int x, int y) {
        switch(CURRENT_MAP) {
            case WORLD_MAP:
                worldMap.mouseMoved(x, y);
                break;
            default:
                localMap.mouseMoved(x, y);
                break;
        } //switch
    } //mouseMoved

    public void mouseWheelMoved(int wheelRotation) {
        switch(CURRENT_MAP) {
            case WORLD_MAP:
                worldMap.mouseWheelMoved(wheelRotation);
                break;
            default:
                localMap.mouseWheelMoved(wheelRotation);
                break;
        } //switch
    } //mouseWheelMoved
}