package backend;


import java.util.Stack;

// import javax.swing.text.Position;

public class GameEngin {
    private backGround board;
    private gameShapes GameShapes;
    private GamePostion p;

    public GameEngin() {
        this.board = FlyWeightFactory.getbackGround(p);
        GameShapes = gameShapes.X;
        // this.p = SingletonPostions.getInstance();
    }

    public void setPlace(GamePostion postion) {
        int row = postion.getRow();
        int col = postion.getCol();
        if (board.getPiece(row, col) == gameShapes.EMPTY) {
            board.setPiece(row, col, GameShapes);
            SwitchShape();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getPiece(i, j) == gameShapes.EMPTY) {
                    System.out.print("Empty   ");
                } else if (board.getPiece(i, j) == gameShapes.X) {
                    System.out.print("X      ");
                } else if (board.getPiece(i, j) == gameShapes.O) {
                    System.out.print("O      ");
                }
            }
            System.out.println();
        }
    }

    private void SwitchShape() {
        if (GameShapes == gameShapes.X) {
            GameShapes = gameShapes.O;
        } else {
            GameShapes = gameShapes.X;
        }
    }

    public Stack<GamePostion> getFreePlaces() {
        Stack<GamePostion> freePlaces = new Stack<GamePostion>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getPiece(row, col) == gameShapes.EMPTY) {
                    freePlaces.push(p);
                    // (new GamePostion(row, col))
                }
            }
        }
        return freePlaces;
    }
// SingletonPostions.getinstance(row, col)
    public gameShapes getcurrentPlayer() {
        return GameShapes;
    }

    public boolean gameOver() {
        return board.isFull() || board.hasWinner();
    }

    public gameShapes getWinner() {
        return GameShapes;
    }

    public backGround getboard() {
        return board;
    }
}
