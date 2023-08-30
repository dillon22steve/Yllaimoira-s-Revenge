package utilz;

import java.awt.Graphics;
import java.awt.FontMetrics;

import render.GamePanel;
import utilz.constants.Constants;

public class HelperMethods {
    
    /*
    public static int CalcPanelWidth() {
        int screenWidth = GamePanel.SCREEN_WIDTH;
        if (screenWidth >= 1920) {
            return 1920;
        } else if (screenWidth >= 1600) {
            return 1600;
        } else if (screenWidth >= 1536) {
            return 1536;
        } else if (screenWidth >= 1440) {
            return 1440;
        } else {
            return 1366;
        } //if
    } //CalcPanelWidth

    public static int CalcPanelHeight() {
        int screenHeight = GamePanel.SCREEN_HEIGHT;
        if (screenHeight >= 1080) {
            return 1080;
        } else if (screenHeight >= 900) {
            return 900;
        } else if (screenHeight >= 864) {
            return 864;
        } else {
            return 768;
        } //if
    } //CalcPanelHeight
    */

    
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
