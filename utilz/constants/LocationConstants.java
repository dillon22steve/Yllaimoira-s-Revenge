package utilz.constants;

import location.Location;
import utilz.HelperMethods;

public class LocationConstants {

    public static Location everton;
    public static Location myrefall;
    public static Location elmlamForest;
    public static Location norfolk;
    public static Location willowdale;
    public static Location halmorHarbor;
    public static Location calmarnock;
    public static Location farkton;

    
    public static void InitLocations() {
        everton = new Location("Atrya.jpg", HelperMethods.LoadImage("TestCity.png"), "Everton", 
            HelperMethods.calcX(1490), HelperMethods.calcY(900),
            HelperMethods.calcX(125), HelperMethods.calcY(125));
        myrefall = new Location("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Myrefall", 
            HelperMethods.calcX(1750), 0,
            HelperMethods.calcX(156), HelperMethods.calcY(156));
        elmlamForest = new Location("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Elmlam Forest", 
            0, HelperMethods.calcY(920),
            HelperMethods.calcX(438), HelperMethods.calcY(194));
        norfolk = new Location("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Norfolk", 
            HelperMethods.calcX(460), HelperMethods.calcY(580),
            HelperMethods.calcX(250), HelperMethods.calcY(130));
        halmorHarbor = new Location("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Halmor Harbor", 
            HelperMethods.calcX(1060), HelperMethods.calcY(610),
            HelperMethods.calcX(188), HelperMethods.calcY(188));
        willowdale = new Location("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Willowdale", 
            HelperMethods.calcX(660), HelperMethods.calcY(210),
            HelperMethods.calcX(220), HelperMethods.calcY(100));
        calmarnock = new Location("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Calmarnock", 
            HelperMethods.calcX(85), HelperMethods.calcY(100),
            HelperMethods.calcX(156), HelperMethods.calcY(130));
        calmarnock = new Location("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Farkton Trading Post", 
            HelperMethods.calcX(1260), HelperMethods.calcY(710),
            HelperMethods.calcX(94), HelperMethods.calcY(97));
    } //InitLocations
    
} //LocationConstants
