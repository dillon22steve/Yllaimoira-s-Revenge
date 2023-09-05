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
			} catch (NullPointerException n) {
                System.out.println(filename);
            }
		} //try

        return imgToReturn;
    } //LoadImage
    

    

    public static double calcFontSize(int sizeAtMaxScreen) {
        return calcY(sizeAtMaxScreen);
    } //calcFontSize




    public static int calcX(int xAtMaxScreen) {
        return ((xAtMaxScreen * GamePanel.SCREEN_WIDTH) / 1920);
    } //calcX

    public static int calcY(int yAtMaxScreen) {
        return ((yAtMaxScreen * GamePanel.SCREEN_HEIGHT) / 1080);
    } //calcY




    public static int calcHorizCenter(Graphics g, int w, String s) {
        FontMetrics fm = g.getFontMetrics();
        return (w - fm.stringWidth(s)) / 2;
    } //calcHorizCenter




    public static int CalcTileSize(int sizeAtMaxScreen) {
        return calcX(sizeAtMaxScreen);
    } //CalcTileSize

    public static int CalcTilesWide(int screenWidth, int tileSize) {
        return (int)(Math.ceil((double)(screenWidth / tileSize)));
    } //CalcTilesWide

    public static int CalcTilesHigh(int screenHeight, int tileSize) {
        return (int)(Math.ceil((double)(screenHeight / tileSize)));
    } //CalcTilesWide
    
}
