package editor;

import javax.swing.JFrame;

public class EditorFrame extends JFrame {
    
    EditorPanel panel;

    public EditorFrame(EditorPanel panel) {
        this.panel = panel;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        /* Uncomment this setUndecored line when the game is ready to play 
         * It gets rid of the title bar at the top.
        */
        //this.setUndecorated(true);

        this.add(panel);

        this.pack();
        this.setVisible(true);
    } //constructor

} //EditorFrame
