package render;

import inputs.*;
import utilz.HelperMethods;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


public class GamePanel extends JPanel {
    public static int GAMEPANEL_WIDTH;
    public static int GAMEPANEL_HEIGHT;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

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
        SCREEN_WIDTH = (int)screenSize.getWidth();
        SCREEN_HEIGHT = (int)screenSize.getHeight();
        // SCREEN_WIDTH = 1400;
        // SCREEN_HEIGHT = 900;
        screenSize = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

        GAMEPANEL_WIDTH = 1536;
        GAMEPANEL_HEIGHT = 864;
        //Dimension testDimension = new Dimension(GAMEPANEL_WIDTH, GAMEPANEL_HEIGHT);

        setMinimumSize(screenSize);
        //setMaximumSize(screenSize);
        //setPreferredSize(screenSize);
        //setPreferredSize(new Dimension(GAMEPANEL_WIDTH, GAMEPANEL_HEIGHT));
        setPreferredSize(screenSize);
    }


    public void update() {

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.getRender().render(g);
    }
}