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

        //GAMEPANEL_WIDTH = HelperMethods.CalcPanelWidth();
        //GAMEPANEL_HEIGHT = HelperMethods.CalcPanelHeight();
        GAMEPANEL_WIDTH = 1366;
        GAMEPANEL_HEIGHT = 768;
        System.out.println("My screen: " + SCREEN_WIDTH + "(width) by " + SCREEN_HEIGHT + "(height)");

        setMinimumSize(new Dimension(GAMEPANEL_WIDTH, GAMEPANEL_HEIGHT));
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