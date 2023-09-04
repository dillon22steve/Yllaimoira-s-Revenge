package utilz.constants;

import java.awt.Font;
import java.awt.image.BufferedImage;

import utilz.HelperMethods;

public class Constants {

    public class Fonts {
        public static Font MAIN_MENU_BTN_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)HelperMethods.calcFontSize(24));
        public static Font MAIN_MENU_TITLE_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)HelperMethods.calcFontSize(64));
        public static Font CHAR_CREAT_BTN_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)HelperMethods.calcFontSize(24));
        public static Font CHAR_CREAT_RACE_NAME_FONT = new Font("Bookman Old Style", Font.BOLD, (int)HelperMethods.calcFontSize(32));
        public static Font CHAR_CREAT_DESC_FONT = new Font("Bookman Old Style", Font.PLAIN, (int)HelperMethods.calcFontSize(18));
        public static Font PAUSE_MENU_BTN_FONT = new Font("Bookman Old Style", Font.ITALIC, (int)HelperMethods.calcFontSize(18));
        public static Font PAUSE_MENU_TITLE_FONT = new Font("Bookman Old Style", Font.BOLD, (int)HelperMethods.calcFontSize(24));
        public static Font MAP_SELECTEDLOCATION_FONT = new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, (int)HelperMethods.calcFontSize(32));
    }

    public class KeyboardConstants {
        public static final int ESC = 27;
        public static final int ENTER = 10;

        public static final int LEFT = 37;
        public static final int UP = 38;
        public static final int RIGHT = 39;
        public static final int DOWN = 40;
    }    
}
