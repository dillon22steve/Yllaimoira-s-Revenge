package utilz;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.awt.FontMetrics;

import render.GamePanel;

public class HelperMethods {

    public static BufferedImage LoadImage(String filename) {
        BufferedImage imgToReturn = null;
        InputStream is = HelperMethods.class.getResourceAsStream("/res/" + filename);
		
		try {
			imgToReturn = ImageIO.read(is);
		} catch (IOException e) {
            System.out.println(filename);
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException io) {
				io.printStackTrace();
			}
		} //try

        return imgToReturn;
    }
    
    public static double calcFontSize(int sizeAtMaxScreen) {
        //return ((sizeAtMaxScreen * (GamePanel.SCREEN_WIDTH * GamePanel.SCREEN_HEIGHT)) / (1920 * 1080));
        return calcY(sizeAtMaxScreen);
    }

    public static int calcX(int xAtMaxScreen) {
        return ((xAtMaxScreen * GamePanel.SCREEN_WIDTH) / 1920);
    }

    public static int calcY(int yAtMaxScreen) {
        return ((yAtMaxScreen * GamePanel.SCREEN_HEIGHT) / 1080);
    }

    public static int calcHorizCenter(Graphics g, int w, String s) {
        FontMetrics fm = g.getFontMetrics();
        return (w - fm.stringWidth(s)) / 2;
    }
    
}
