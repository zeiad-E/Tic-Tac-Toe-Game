package backend;

import java.util.Random;

public class OnePlayer extends Player {
    GameEngin g;
    ObserverGame o;
    private int row;
    private int col;
    Random rand = new Random();

    public OnePlayer(GameEngin g, ObserverGame o) {
        this.g = g;
        this.o = o;
    }

    @Override
    public void play(int r, int c) {
        row = r;
        col = c;
        GamePostion pos = new GamePostion(row, col);
        g.setPlace(pos);
        o.registerObserver(g);
        computerSelect();
    }

    private void computerSelect() {
        System.out.println("__________________________\n");
        boolean b = false;
        boolean gameOver = g.getboard().hasWinner();
        while (!b) {
            if (!gameOver) {
                row = rand.nextInt(3);
                col = rand.nextInt(3);
                if (g.getboard().getPiece(row, col) == gameShapes.EMPTY) {
                    // try to remove if after test
                    // if (row == i || col == j) {
                    // break;
                    // } else {
                    // row = rand.nextInt(3);
                    // col = rand.nextInt(3);
                    b = true;
                    GamePostion pos = new GamePostion(row, col);
                    g.setPlace(pos);
                    o.registerObserver(g);
                }
            }
        }
    }
    // void search()
}
