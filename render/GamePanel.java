package render;

import inputs.*;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


public class GamePanel extends JPanel {
    private Game game;

    private Dimension size;
    private Dimension testSize;

    private int width, height;

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
        //size = new Dimension(1280, 1000);
        testSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int)testSize.getWidth();
        height = (int)testSize.getHeight();

        size = testSize;
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }


    public void update() {

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.getRender().render(g);
    }


    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
}