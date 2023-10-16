package render;

import inputs.*;
import utilz.HelperMethods;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


public class GamePanel extends JPanel {
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public static int TILE_SIZE;
    public static int TILES_WIDE;
    public static int TILES_HIGH;

    private Game game;

    private Dimension screenSize;

    private MouseInputs mouseInputs;
    private KeyboardInputs keyBoardInputs;


    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        this.setBackground(Color.BLACK);
    } //constructor


    public void initInputs() {
        this.mouseInputs = new MouseInputs(game);
        this.keyBoardInputs = new KeyboardInputs(game);

        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        addMouseWheelListener(mouseInputs);
        addKeyListener(keyBoardInputs);

        requestFocus();
    } //initInputs


    private void setPanelSize() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_WIDTH = (int)screenSize.getWidth();
        SCREEN_HEIGHT = (int)screenSize.getHeight();
        // SCREEN_WIDTH = 1400;
        // SCREEN_HEIGHT = 900;
        screenSize = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

        TILE_SIZE = HelperMethods.CalcTileSize(64);
        TILES_WIDE = HelperMethods.CalcTilesWide(SCREEN_WIDTH, TILE_SIZE);
        TILES_HIGH = HelperMethods.CalcTilesWide(SCREEN_HEIGHT, TILE_SIZE);

        setMinimumSize(screenSize);
        //setMaximumSize(screenSize);
        setPreferredSize(screenSize);
    } //setPanelSize


    public void update() {

    } //update


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.getRender().render(g);
    } //paintComponent
} //GamePanel