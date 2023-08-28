package render;

import inputs.*;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


public class GamePanel extends JPanel {
    private Game game;

    private Dimension screenSize;

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
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int)screenSize.getWidth();
        height = (int)screenSize.getHeight();
        System.out.println(width + "(width) by " + height + "(height)");
        setPreferredSize(screenSize);
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