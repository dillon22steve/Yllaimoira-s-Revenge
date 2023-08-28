package gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import utilz.Constants;

public class Map implements GameStateInterface {

    private BufferedImage atryaWorldMap;
    private boolean isWorldMap = true;

    public Map() {
        initImg();
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

    public void render(Graphics g) {
        if (isWorldMap) {
            g.drawImage(atryaWorldMap, 50, 50, 1180, 900, null);
            g.setFont(Constants.Fonts.MAIN_MENU_BTN_FONT);
            g.setColor(Color.WHITE);
            g.drawString("<Press L for the local map>", 450, 925);
        } else {
            g.drawString("<Press W for the world map>", 450, 925);
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
