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
        public static final int BUSH = 32;
        public static final int INN_1 = 33;
        public static final int INN_2 = 34;
        public static final int INN_3 = 35;
        public static final int INN_4 = 36;
        public static final int INN_5 = 37;
        public static final int INN_6 = 38;
        public static final int INN_7 = 39;
        public static final int INN_8 = 40;
        public static final int INN_9 = 41;
        public static final int INN_10 = 42;
        public static final int INN_11 = 43;
        public static final int INN_12 = 44;
        public static final int INN_13 = 45;
        public static final int INN_14 = 46;
        public static final int INN_15 = 47;
        public static final int INN_16 = 48;
    } //ID

    public class IMG {
        public static BufferedImage[] ART = new BufferedImage[49];

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
            ART[ID.BUSH] = HelperMethods.LoadImage("Bush.jpg");
            ART[ID.INN_1] = HelperMethods.LoadImage("/buildings/inn/inn1.jpg");
            ART[ID.INN_2] = HelperMethods.LoadImage("/buildings/inn/inn2.jpg");
            ART[ID.INN_3] = HelperMethods.LoadImage("/buildings/inn/inn3.jpg");
            ART[ID.INN_4] = HelperMethods.LoadImage("/buildings/inn/inn4.jpg");
            ART[ID.INN_5] = HelperMethods.LoadImage("/buildings/inn/inn5.jpg");
            ART[ID.INN_6] = HelperMethods.LoadImage("/buildings/inn/inn6.jpg");
            ART[ID.INN_7] = HelperMethods.LoadImage("/buildings/inn/inn7.jpg");
            ART[ID.INN_8] = HelperMethods.LoadImage("/buildings/inn/inn8.jpg");
            ART[ID.INN_9] = HelperMethods.LoadImage("/buildings/inn/inn9.jpg");
            ART[ID.INN_10] = HelperMethods.LoadImage("/buildings/inn/inn10.jpg");
            ART[ID.INN_11] = HelperMethods.LoadImage("/buildings/inn/inn11.jpg");
            ART[ID.INN_12] = HelperMethods.LoadImage("/buildings/inn/inn12.jpg");
            ART[ID.INN_13] = HelperMethods.LoadImage("/buildings/inn/inn13.jpg");
            ART[ID.INN_14] = HelperMethods.LoadImage("/buildings/inn/inn14.jpg");
            ART[ID.INN_15] = HelperMethods.LoadImage("/buildings/inn/inn15.jpg");
            ART[ID.INN_16] = HelperMethods.LoadImage("/buildings/inn/inn16.jpg");
        } //LoadImages
    } //IMG
} //TileConstants
