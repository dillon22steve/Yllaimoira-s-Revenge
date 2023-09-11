package utilz.constants;

import location.Location;
import utilz.HelperMethods;

public class LocationConstants {

    public static Location EVERTON;
    public static Location MYREFALL;
    public static Location ELMLAM_FOREST;
    public static Location NORFOLK;
    public static Location WILLOWDALE;
    public static Location HALMOR_HARBOR;
    public static Location CALMARNOCK;
    public static Location FARKTON;

    
    public static void InitLocations() {
        EVERTON = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Everton", 
            HelperMethods.calcX(1490), HelperMethods.calcY(900),
            HelperMethods.calcX(125), HelperMethods.calcY(125));
        MYREFALL = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Myrefall", 
            HelperMethods.calcX(1750), 0,
            HelperMethods.calcX(156), HelperMethods.calcY(156));
        ELMLAM_FOREST = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Elmlam Forest", 
            0, HelperMethods.calcY(920),
            HelperMethods.calcX(438), HelperMethods.calcY(194));
        NORFOLK = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Norfolk", 
            HelperMethods.calcX(460), HelperMethods.calcY(580),
            HelperMethods.calcX(250), HelperMethods.calcY(130));
        HALMOR_HARBOR = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Halmor Harbor", 
            HelperMethods.calcX(1060), HelperMethods.calcY(610),
            HelperMethods.calcX(188), HelperMethods.calcY(188));
        WILLOWDALE = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Willowdale", 
            HelperMethods.calcX(660), HelperMethods.calcY(210),
            HelperMethods.calcX(220), HelperMethods.calcY(100));
        CALMARNOCK = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Calmarnock", 
            HelperMethods.calcX(85), HelperMethods.calcY(100),
            HelperMethods.calcX(156), HelperMethods.calcY(130));
        FARKTON = new Location("Atrya", HelperMethods.LoadImage("TestLevel2"), "Farkton Trading Post", 
            HelperMethods.calcX(1260), HelperMethods.calcY(710),
            HelperMethods.calcX(94), HelperMethods.calcY(97));
    } //InitLocations
    
} //LocationConstants
