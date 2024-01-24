package backend;

public class ObserverGame {

    public void registerObserver(GameEngin gameEngin) {
        if (gameEngin.getboard().isFull()) {
            System.out.println("The game is full\nPlease Play Again");
        } else if (gameEngin.getboard().hasWinner()) {
            if (gameEngin.getWinner() == gameShapes.X)
                System.out.println("O wins");
            else if (gameEngin.getWinner() == gameShapes.O)
                System.out.println("X wins");
        }
    }
}
