package map;

import java.util.ArrayList;

import javax.imageio.ImageIO;

import gamestate.GameStates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import location.Location;
import utilz.HelperMethods;
import utilz.constants.Constants;
import gamestate.Map;

public class WorldMap extends map.Map {

    private ArrayList<Location> locations;
    private int selectedLocationId;
    private Location selectedLocation;

    public WorldMap() {
        super();
        initImg();

        //For testing purposes only. Delete this later.
        //selectedLocation = new Location("Atrya.jpg", "Everton", 900, 800);
    }
    private void initImg() {
        InputStream is = getClass().getResourceAsStream("/res/Atrya.jpg");
		
		try {
			this.mapImg = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		} //try
    } //InitImg


    public void render(Graphics g) {
        drawMap(g);
        drawSelection(g);
    }

    private void drawMap(Graphics g) {
        g.drawImage(mapImg, mapCoord, mapCoord, mapWidth, mapHeight, null);

        g.setFont(Constants.Fonts.MAP_SELECTEDLOCATION_FONT);
        g.setColor(Color.WHITE);
        stringX = HelperMethods.calcHorizCenter(g, mapWidth, "<Press L for the World map>");
        g.drawString("<Press L for the local map>", stringX, stringY);
    }

    private void drawSelection(Graphics g) {
        g.setFont(Constants.Fonts.MAP_SELECTEDLOCATION_FONT);
        if (selectedLocation != null) {
            g.drawString("->", selectedLocation.getX() - 10, selectedLocation.getY());
        }
    }


    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.ESC:
                GameStates.GameState = GameStates.PLAYING;
                break;
            case 'L':
                gamestate.Map.CURRENT_MAP = gamestate.Map.LOCAL_MAP;
                break;
            case Constants.KeyboardConstants.UP:
                updateSelection(true);
                break;
            case Constants.KeyboardConstants.DOWN:
                updateSelection(false);

                selectedLocation = locations.get(selectedLocationId);
                break;
        }
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    public void mouseMoved(int x, int y) {
        //checkLocationBounds(x, y);
    }

    public void mouseWheelMoved(int wheelRotation) {
        if (wheelRotation > 0) {
            updateSelection(false);
        } else {
            updateSelection(true);
        }
    }

    private void updateSelection(boolean up) {
        if (up) {
            if (selectedLocationId < locations.size() - 1) {
                    selectedLocationId++;
                } else {
                    selectedLocationId = 0;
                }
        } else {
            if (selectedLocationId > 0) {
                    selectedLocationId--;
                } else {
                    selectedLocationId = locations.size() - 1;
                }
        } //if

        selectedLocation = locations.get(selectedLocationId);
    } //updateSelection

    private void checkLocationBounds(int x, int y) {
        for (int i = 0; i < locations.size(); i++) {
            Location locAtIndex = locations.get(i);
            if (locAtIndex.getBounds().contains(x, y)) {
                selectedLocation = locAtIndex;
                selectedLocationId = i;
            }
        }
    }
}
