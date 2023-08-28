package render;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    private GamePanel gamePanel;
    private Render render;
    
    public GameFrame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setResizable(true);



        this.add(gamePanel);

        this.pack();
        this.setVisible(true);
    }

}