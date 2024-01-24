package backend;

import java.util.Scanner;

public class TwoPlayers {
    GameEngin g = new GameEngin();
    ObserverGame o = new ObserverGame();
    public TwoPlayers() {
        while (!g.gameOver()) {
            Scanner s = new Scanner(System.in);
            // System.out.println("efefef");
            int row = s.nextInt();
            int col = s.nextInt();
            GamePostion pos = new GamePostion(row, col);
            g.setPlace(pos);
            o.registerObserver(g);
        }
    }
}
