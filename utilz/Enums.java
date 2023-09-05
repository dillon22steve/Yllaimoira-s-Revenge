package utilz;

public class Enums {
    
    public enum CharacterCreationStates {
        RACE_SELECT,
        CLASS_SELECT,
        BACKGROUND_SELECT;

        public static CharacterCreationStates State = RACE_SELECT;
    } //CharacterCreationStates


    public enum CharacterMenuStates {
        SELECTION,
        LEVEL_UP,
        INVENTORY,
        QUEST_JOURNAL;

        public static CharacterMenuStates State = SELECTION;
    }
    
}
