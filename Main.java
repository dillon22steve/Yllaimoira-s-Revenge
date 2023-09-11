import render.Game;
import utilz.HelperMethods;
import utilz.constants.TileConstants;

public class Main {
    public static void main(String[] args) {
        HelperMethods.runNow(() -> {
            TileConstants.IMG.LoadImages();
        });
        Game game = new Game();
        game.getGamePanel().initInputs();
        game.start();
    }
}