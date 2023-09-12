import render.Game;
import utilz.HelperMethods;

public class Main {
    public static void main(String[] args) {
        HelperMethods.LoadGame();
        Game game = new Game();
        game.getGamePanel().initInputs();
        game.start();
    }
}