package map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gamestate.GameStates;
import utilz.HelperMethods;
import utilz.constants.Constants;

public class LocalMap extends map.Map {
    
    public LocalMap() {
        super();
    } //constructor


    public void render(Graphics g) {
        drawMap(g);
    } //render

    private void drawMap(Graphics g) {
        g.drawImage(mapImg, mapCoord, mapCoord, mapWidth, mapHeight, null);

        g.setFont(Constants.Fonts.MAP_SELECTEDLOCATION_FONT);
        g.setColor(Color.WHITE);
        stringX = HelperMethods.calcHorizCenter(g, mapWidth, "<Press W for the World map>");
        g.drawString("<Press W for the local map>", stringX, stringY);
    }


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.ESC:
                GameStates.GameState = GameStates.PLAYING;
                gamestate.Map.CURRENT_MAP = gamestate.Map.WORLD_MAP;
                break;
            case 'W':
                gamestate.Map.CURRENT_MAP = gamestate.Map.WORLD_MAP;
                break;
        } //switch
    } //keyPressed


    public void mouseClicked(int x, int y) {
    } //mouseClicked


    public void mouseMoved(int x, int y) {
    } //mouseMoved


    public void mouseWheelMoved(int wheelRotation) {
    } //mouseWheelMoved
}
