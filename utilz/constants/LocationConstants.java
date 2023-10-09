package utilz.constants;

import location.City;
import location.Location;
import utilz.HelperMethods;

public class LocationConstants {

    public static City everton;
    public static City myrefall;
    public static City elmlamForest;
    public static City norfolk;
    public static City willowdale;
    public static City halmorHarbor;
    public static City calmarnock;
    public static City farkton;

    
    public static void InitLocations() {
        everton = new City("Atrya.jpg", HelperMethods.LoadImage("TestCity.png"), "Everton", 
            HelperMethods.calcX(1490), HelperMethods.calcY(900),
            HelperMethods.calcX(125), HelperMethods.calcY(125));
        myrefall = new City("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Myrefall", 
            HelperMethods.calcX(1750), 0,
            HelperMethods.calcX(156), HelperMethods.calcY(156));
        elmlamForest = new City("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Elmlam Forest", 
            0, HelperMethods.calcY(920),
            HelperMethods.calcX(438), HelperMethods.calcY(194));
        norfolk = new City("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Norfolk", 
            HelperMethods.calcX(460), HelperMethods.calcY(580),
            HelperMethods.calcX(250), HelperMethods.calcY(130));
        halmorHarbor = new City("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Halmor Harbor", 
            HelperMethods.calcX(1060), HelperMethods.calcY(610),
            HelperMethods.calcX(188), HelperMethods.calcY(188));
        willowdale = new City("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Willowdale", 
            HelperMethods.calcX(660), HelperMethods.calcY(210),
            HelperMethods.calcX(220), HelperMethods.calcY(100));
        calmarnock = new City("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Calmarnock", 
            HelperMethods.calcX(85), HelperMethods.calcY(100),
            HelperMethods.calcX(156), HelperMethods.calcY(130));
        calmarnock = new City("Atrya.jpg", HelperMethods.LoadImage("TestLevel2.png"), "Farkton Trading Post", 
            HelperMethods.calcX(1260), HelperMethods.calcY(710),
            HelperMethods.calcX(94), HelperMethods.calcY(97));

        BuildingConstants.InitBuildings();
    } //InitLocations
    
} //LocationConstants
