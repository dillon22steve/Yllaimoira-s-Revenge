package utilz;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import location.Enterable;
import location.Building;

import java.awt.FontMetrics;

import render.GamePanel;
import utilz.constants.TileConstants;
import utilz.constants.character_constants.EnemyConstants;
import utilz.constants.location_constants.BuildingConstants;
import utilz.constants.location_constants.LocationConstants;

public class HelperMethods {

    public static void LoadGame() {
        /*
        runNow(() -> TileConstants.IMG.LoadImages());
        runNow(() -> LocationConstants.InitLocations());
        runNow(() -> BuildingConstants.InitBuildings());
        */
        TileConstants.IMG.LoadImages();
        EnemyConstants.InitEnemies();
        LocationConstants.InitLocations();
        BuildingConstants.InitBuildings();
    } //LoadGame

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



    public static void runNow(Runnable target) {
        Thread thread = new Thread(target);
        thread.setDaemon(true);
        thread.start();
    } //runNow
    

    

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




    public static Enterable DetermineBuilding(int tile) {
        if (tile >= TileConstants.ID.NOBLE_HOME_1 && tile <= TileConstants.ID.NOBLE_HOME_16) {
            return BuildingConstants.DungeonConstants.testDungeon;
        } else if (tile >= TileConstants.ID.INN_1 && tile <= TileConstants.ID.INN_18) {
            return null;
        } else if (tile >= TileConstants.ID.TAVERN_1 && tile <= TileConstants.ID.TAVERN_15) {
            return BuildingConstants.tavern;
        } else if (tile >= TileConstants.ID.WEAPON_SHOP_1 && tile <= TileConstants.ID.WEAPON_SHOP_12) {
            return null;
        } else {
            return null;
        }
    } //DetermineBuilding
    
} //HelperMethods
