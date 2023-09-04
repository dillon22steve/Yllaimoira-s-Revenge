import render.Game;
import utilz.constants.TileConstants;

public class Main {
    public static void main(String[] args) {
        TileConstants.IMG.LoadImages();
        Game game = new Game();
        game.getGamePanel().initInputs();
        game.start();
    }
}