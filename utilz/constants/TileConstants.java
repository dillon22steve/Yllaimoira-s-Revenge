package utilz.constants;

import utilz.HelperMethods;
import java.awt.image.BufferedImage;

public class TileConstants {
    
    public class ID {
        public static final int GRASS = 0;
        public static final int WATER = 1;
        public static final int COBBLESTONE = 2;
        public static final int PLANK_VERT = 3;
        public static final int PLANK_HORI = 4;
        public static final int PLANK_UP_RIGHT = 5;
        public static final int PLANK_UP_LEFT = 6;
        public static final int PLANK_DOWN_RIGHT = 7;
        public static final int PLANK_DOWN_LEFT = 8;
    } //ID

    public class IMG {
        public static BufferedImage GRASS;
        public static BufferedImage WATER;
        public static BufferedImage COBBLESTONE;
        public static BufferedImage PLANK_VERT;
        public static BufferedImage PLANK_HORI;
        public static BufferedImage PLANK_UP_RIGHT;
        public static BufferedImage PLANK_UP_LEFT;
        public static BufferedImage PLANK_DOWN_RIGHT;
        public static BufferedImage PLANK_DOWN_LEFT;

        public static void LoadImages() {
            GRASS = HelperMethods.LoadImage("GrassBlock.jpg");
            WATER = HelperMethods.LoadImage("WaterBlock.jpg");
            COBBLESTONE = HelperMethods.LoadImage("CobblestoneBlock.jpg");
            PLANK_VERT = HelperMethods.LoadImage("/planks/LightPlank.jpg");
            PLANK_HORI = HelperMethods.LoadImage("/planks/LightPlankSide.jpg");
            PLANK_UP_RIGHT = HelperMethods.LoadImage("/planks/LightPlankUpRight.jpg");
            PLANK_UP_LEFT = HelperMethods.LoadImage("/planks/LightPlankUpLeft.jpg");
            PLANK_DOWN_RIGHT = HelperMethods.LoadImage("/planks/LightPlankBottomRight.jpg");
            PLANK_DOWN_LEFT = HelperMethods.LoadImage("/planks/LightPlankBottomLeft.jpg");
        } //LoadImages
    } //IMG
} //TileConstants
