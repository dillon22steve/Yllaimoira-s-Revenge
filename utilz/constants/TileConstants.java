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
        public static BufferedImage[] ART = new BufferedImage[9];

        public static void LoadImages() {
            ART[ID.GRASS] = HelperMethods.LoadImage("GrassBlock.jpg");;
            ART[ID.WATER] = HelperMethods.LoadImage("WaterBlock.jpg");
            ART[ID.COBBLESTONE] = HelperMethods.LoadImage("CobblestoneBlock.jpg");
            ART[ID.PLANK_VERT] = HelperMethods.LoadImage("/planks/LightPlank.jpg");
            ART[ID.PLANK_HORI] = HelperMethods.LoadImage("/planks/LightPlankSide.jpg");
            ART[ID.PLANK_UP_RIGHT] = HelperMethods.LoadImage("/planks/LightPlankUpRight.jpg");
            ART[ID.PLANK_UP_LEFT] = HelperMethods.LoadImage("/planks/LightPlankUpLeft.jpg");
            ART[ID.PLANK_DOWN_RIGHT] = HelperMethods.LoadImage("/planks/LightPlankBottomRight.jpg");
            ART[ID.PLANK_DOWN_LEFT] = HelperMethods.LoadImage("/planks/LightPlankBottomLeft.jpg");
        } //LoadImages
    } //IMG
} //TileConstants
