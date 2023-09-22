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
        public static final int BLDG1_TOP_LEFT = 12;
        public static final int BLDG1_TOP_RIGHT = 13;
        public static final int BLDG1_BOTTOM_LEFT = 14;
        public static final int BLDG1_BOTTOM_RIGHT = 15;
        public static final int NOBLE_HOME_1 = 16;
        public static final int NOBLE_HOME_2 = 17;
        public static final int NOBLE_HOME_3 = 18;
        public static final int NOBLE_HOME_4 = 19;
        public static final int NOBLE_HOME_5 = 20;
        public static final int NOBLE_HOME_6 = 21;
        public static final int NOBLE_HOME_7 = 22;
        public static final int NOBLE_HOME_8 = 23;
        public static final int NOBLE_HOME_9 = 24;
        public static final int NOBLE_HOME_10 = 25;
        public static final int NOBLE_HOME_11 = 26;
        public static final int NOBLE_HOME_12 = 27;
        public static final int NOBLE_HOME_13 = 28;
        public static final int NOBLE_HOME_14 = 29;
        public static final int NOBLE_HOME_15 = 30;
        public static final int NOBLE_HOME_16 = 31;
    } //ID

    public class IMG {
        public static BufferedImage[] ART = new BufferedImage[32];

        public static void LoadImages() {
            ART[ID.GRASS] = HelperMethods.LoadImage("GrassBlock.jpg");
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
            ART[ID.BLDG1_TOP_LEFT] = HelperMethods.LoadImage("/buildings/Bldg1TopLeft.jpg");
            ART[ID.BLDG1_TOP_RIGHT] = HelperMethods.LoadImage("/buildings/Bldg1TopRight.jpg");
            ART[ID.BLDG1_BOTTOM_LEFT] = HelperMethods.LoadImage("/buildings/Bldg1BottomLeft.jpg");
            ART[ID.BLDG1_BOTTOM_RIGHT] = HelperMethods.LoadImage("/buildings/Bldg1BottomRight.jpg");
            ART[ID.NOBLE_HOME_1] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome1.jpg");
            ART[ID.NOBLE_HOME_2] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome2.jpg");
            ART[ID.NOBLE_HOME_3] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome3.jpg");
            ART[ID.NOBLE_HOME_4] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome4.jpg");
            ART[ID.NOBLE_HOME_5] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome5.jpg");
            ART[ID.NOBLE_HOME_6] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome6.jpg");
            ART[ID.NOBLE_HOME_7] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome7.jpg");
            ART[ID.NOBLE_HOME_8] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome8.jpg");
            ART[ID.NOBLE_HOME_9] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome9.jpg");
            ART[ID.NOBLE_HOME_10] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome10.jpg");
            ART[ID.NOBLE_HOME_11] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome11.jpg");
            ART[ID.NOBLE_HOME_12] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome12.jpg");
            ART[ID.NOBLE_HOME_13] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome13.jpg");
            ART[ID.NOBLE_HOME_14] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome14.jpg");
            ART[ID.NOBLE_HOME_15] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome15.jpg");
            ART[ID.NOBLE_HOME_16] = HelperMethods.LoadImage("/buildings/noble_home/NobleHome16.jpg");
        } //LoadImages
    } //IMG
} //TileConstants
