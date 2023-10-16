import editor.Editor;

public class EditorDriver {
    
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.getEditorPanel().initInputs();
        editor.start();
    } //main

} //EditorDriver
