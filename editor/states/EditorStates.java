package editor.states;

public enum EditorStates {
    CHOOSE_BUILDING,
    EDITOR_MODE,
    PAUSE;

    public static EditorStates EditorState = CHOOSE_BUILDING;

    public static void setState(EditorStates EditorState) {
        EditorStates.EditorState = EditorState;
    } //setState
} //EditorStates
