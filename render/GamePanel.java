package render;

import inputs.*;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


public class GamePanel extends JPanel {
    public static int GAMEPANEL_WIDTH;
    public static int GAMEPANEL_HEIGHT;

    private Game game;

    private Dimension screenSize;

    private MouseInputs mouseInputs;
    private KeyboardInputs keyBoardInputs;


    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        this.setBackground(Color.BLACK);
    }


    public void initInputs() {
        this.mouseInputs = new MouseInputs(game);
        this.keyBoardInputs = new KeyboardInputs(game);

        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        addMouseWheelListener(mouseInputs);
        addKeyListener(keyBoardInputs);

        requestFocus();
    }


    private void setPanelSize() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        GAMEPANEL_WIDTH = (int)screenSize.getWidth();
        GAMEPANEL_HEIGHT = (int)screenSize.getHeight();
        setPreferredSize(screenSize);
    }


    public void update() {

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.getRender().render(g);
    }
}