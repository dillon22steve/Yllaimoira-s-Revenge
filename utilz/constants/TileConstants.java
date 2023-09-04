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
        public static final int TREE_TRUNK = 9;
        public static final int TREE_MIDDLE = 10;
        public static final int TREE_TOP = 11;
    } //ID

    public class IMG {
        public static BufferedImage[] ART = new BufferedImage[12];

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
            ART[ID.TREE_TRUNK] = HelperMethods.LoadImage("/trees/TreeTrunk.jpg");
            ART[ID.TREE_MIDDLE] = HelperMethods.LoadImage("/trees/TreeMiddle.jpg");
            ART[ID.TREE_TOP] = HelperMethods.LoadImage("/trees/TreeTop.jpg");
        } //LoadImages
    } //IMG
} //TileConstants
