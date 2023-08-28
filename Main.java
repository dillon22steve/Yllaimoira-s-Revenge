import render.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.getGamePanel().initInputs();
        game.start();
    }
}