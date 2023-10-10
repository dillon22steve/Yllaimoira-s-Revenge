package utilz.constants;

import location.Building;
import utilz.HelperMethods;

public class BuildingConstants {
    
    public static Building tavern;

    public static void InitBuildings() {
        tavern = new Building("Atrya.jpg", HelperMethods.LoadImage("/buildings/tavern/TavernInterior.jpg"), "Everton Tavern", 
            HelperMethods.calcX(1490), HelperMethods.calcY(900), 
            HelperMethods.calcX(125), HelperMethods.calcY(125),
            LocationConstants.everton, 9);
    } //InitBuildings

} //BuildingConstants
