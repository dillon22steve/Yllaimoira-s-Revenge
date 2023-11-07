package utilz.constants.location_constants;

import location.Building;
import location.Dungeon;
import utilz.HelperMethods;

public class BuildingConstants {
    
    public static Building tavern;

    public static void InitBuildings() {
        tavern = new Building("Atrya.jpg", HelperMethods.LoadImage("/buildings/tavern/TavernInterior.jpg"), "Everton Tavern", 
            HelperMethods.calcX(1490), HelperMethods.calcY(900), 
            HelperMethods.calcX(125), HelperMethods.calcY(125),
            LocationConstants.everton, 9);
    } //InitBuildings


    public class DungeonConstants {
        
        public static Dungeon testDungeon;

        public static void InitDungeons() {
            testDungeon = new Dungeon("Atrya.jpg", HelperMethods.LoadImage("/buildings/tavern/TavernInterior.jpg"), "Test Dungeon", 
                HelperMethods.calcX(1490), HelperMethods.calcY(900), 
                HelperMethods.calcX(125), HelperMethods.calcY(125),
                LocationConstants.everton, 9);
        } //InitDungeons
    } //DungeonConstants

} //BuildingConstants
