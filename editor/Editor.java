package editor;

import editor.states.*;

public class Editor implements Runnable {

    private EditorFrame frame;
    private EditorPanel panel;

    private final double FPS_SET = 120;
    private final double UPS_SET = 200;

    private Thread editorThread;

    private ChooseBuilding chooseBuilding;
    private EditBuilding editBuilding;
    private Pause pause;

    public Editor() {
        this.panel = new EditorPanel(this);
        this.frame = new EditorFrame(panel);
        this.chooseBuilding = new ChooseBuilding(this);
        this.editBuilding = new EditBuilding();
        this.pause = new Pause(this);
    } //constructor


    public void start() {
        this.editorThread = new Thread(this);
        editorThread.start();
    } //start


    public void update() {
        panel.update();
    } //update


    @Override
    public void run() {
        double timePerFrame = (1_000_000_000.0 / FPS_SET);
		double timePerUpdate = (1_000_000_000.0 / UPS_SET);
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long now = System.nanoTime();

        /*
        long lastTimeCheck = 0;
        int frames = 0;
        int updates = 0;
        */

        while(true) {
            now = System.nanoTime();

            if((now - lastFrame) >= timePerFrame) {
                lastFrame = now;
                panel.repaint();
                //frames++;
            } //if

            if((now - lastUpdate) >= timePerUpdate) {
                lastUpdate = now;
                update();
                //updates++;
            } //if

            /* 
            if ( System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("frames: " + frames + " | updates: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            } //if
            */
            
        } //while
    } //run


    public ChooseBuilding getChooseBuilding() {
        return chooseBuilding;
    } //getChooseBuilding

    public EditBuilding getEditBuilding() {
        return editBuilding;
    } //getEditBuilding

    public EditorPanel getEditorPanel() {
        return this.panel;
    } //getEditorPanel

    public Pause getPause() {
        return this.pause;
    } //getPause
    
} //Editor
