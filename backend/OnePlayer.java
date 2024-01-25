package backend;

import java.util.Random;

public class OnePlayer {
    GameEngin g;
    ObserverGame o;
    private int row;
    private int col;
    Random rand = new Random();

    public OnePlayer(GameEngin g, ObserverGame o) {
        this.g = g;
        this.o = o;
    }

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
        row = rand.nextInt(3);
        col = rand.nextInt(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (g.getboard().getPiece(i, j) == gameShapes.EMPTY) {
                    // try to remove if after test
                    if (row == i || col == j) {
                        break;
                    } else {
                        row = rand.nextInt(3);
                        col = rand.nextInt(3);
                    }
                }
            }
        }
        GamePostion pos = new GamePostion(row, col);
        g.setPlace(pos);
        o.registerObserver(g);
    }
    // void search()
}
