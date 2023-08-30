package gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utilz.HelperMethods;
import utilz.constants.Constants;

public class Map implements GameStateInterface {

    private BufferedImage atryaWorldMap;
    private boolean isWorldMap = true;
    private int mapCoord, mapWidth, mapHeight;
    private int stringX, stringY;

    public Map() {
        initImg();
        initMapSize();
    }

    private void initImg() {
        InputStream is = getClass().getResourceAsStream("/res/Atrya.jpg");
		
		try {
			atryaWorldMap = ImageIO.read(is);
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

    private void initMapSize() {
        mapCoord = HelperMethods.calcX(50);
        mapWidth = HelperMethods.calcX(1180);
        mapHeight = HelperMethods.calcY(900);
        stringX = HelperMethods.calcX(450);
        stringY = HelperMethods.calcY(925);
    }

    public void render(Graphics g) {
        if (isWorldMap) {
            g.drawImage(atryaWorldMap, mapCoord, mapCoord, mapWidth, mapHeight, null);
            g.setFont(Constants.Fonts.MAIN_MENU_BTN_FONT);
            g.setColor(Color.WHITE);
            g.drawString("<Press L for the local map>", stringX, stringY);
        } else {
            g.drawString("<Press W for the world map>", stringX, stringY);
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case Constants.KeyboardConstants.ESC:
                GameStates.GameState = GameStates.PLAYING;
                break;
            case 'L':
                isWorldMap = false;
                break;
            case 'W':
                isWorldMap = true;
                break;
        }
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    public void mouseWheelMoved(int wheelRotation) {
    }
    
}
