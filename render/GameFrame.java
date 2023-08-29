package render;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private GamePanel gamePanel;
    private Render render;
    
    public GameFrame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        /* Uncomment this setUndecored line when the game is ready to play 
         * It gets rid of the title bar at the top.
        */
        this.setUndecorated(true);



        this.add(gamePanel);

        this.pack();
        this.setVisible(true);
    }

}