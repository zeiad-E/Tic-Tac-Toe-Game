package backend;

public class GamePostion {
    private int row;
    private int col;

    public GamePostion(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // public void reset() {
    //     this.row = 0;
    //     this.col = 0;
    // }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
