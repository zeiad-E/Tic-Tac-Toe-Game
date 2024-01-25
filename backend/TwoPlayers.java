package backend;

public class TwoPlayers {
    GameEngin g;
    ObserverGame o;
    private int row;
    private int col;

    public TwoPlayers(GameEngin g, ObserverGame o) {
        this.g = g;
        this.o = o;
    }

    public void play(int r, int c) {
        row = r;
        col = c;
        GamePostion pos = new GamePostion(row, col);
        g.setPlace(pos);
        o.registerObserver(g);
    }
}