package backend;

public class backGround {
    private gameShapes[][] ShapeInboard;

    public backGround() {
        ShapeInboard = new gameShapes[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ShapeInboard[i][j] = gameShapes.EMPTY;
                System.out.print("Empty   ");
            }
            System.out.println("");
        }
    }

    public void setPiece(int row, int col, gameShapes piece) {
        ShapeInboard[row][col] = piece;
    }

    public gameShapes getPiece(int row, int col) {
        return ShapeInboard[row][col];
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ShapeInboard[i][j] == gameShapes.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner() {
        //To check rows
        for (int i = 0; i < 3; i++) {
            if (ShapeInboard[i][0] != gameShapes.EMPTY &&
                    ShapeInboard[i][0] == ShapeInboard[i][1] &&
                    ShapeInboard[i][1] == ShapeInboard[i][2]) {
                return true;
            }
        }

        // To check columns
        for (int i = 0; i < 3; i++) {
            if (ShapeInboard[0][i] != gameShapes.EMPTY &&
                    ShapeInboard[0][i] == ShapeInboard[1][i] &&
                    ShapeInboard[1][i] == ShapeInboard[2][i]) {
                return true;
            }
        }

        // To check diagonals
        if (ShapeInboard[0][0] != gameShapes.EMPTY &&
                ShapeInboard[0][0] == ShapeInboard[1][1] &&
                ShapeInboard[1][1] == ShapeInboard[2][2]) {
            return true;
        }

        if (ShapeInboard[0][2] != gameShapes.EMPTY &&
                ShapeInboard[0][2] == ShapeInboard[1][1] &&
                ShapeInboard[1][1] == ShapeInboard[2][0]) {
            return true;
        }

        return false;
    }

    public gameShapes getWinner() {
        if (hasWinner()) {
            for (int i = 0; i < 3; i++) {
                if (ShapeInboard[i][0] != gameShapes.EMPTY &&
                        ShapeInboard[i][0] == ShapeInboard[i][1] &&
                        ShapeInboard[i][1] == ShapeInboard[i][2]) {
                    return ShapeInboard[i][0];
                }
            }

            for (int i = 0; i < 3; i++) {
                if (ShapeInboard[0][i] != gameShapes.EMPTY &&
                        ShapeInboard[0][i] == ShapeInboard[1][i] &&
                        ShapeInboard[1][i] == ShapeInboard[2][i]) {
                    return ShapeInboard[0][i];
                }
            }

            if (ShapeInboard[0][0] != gameShapes.EMPTY &&
                    ShapeInboard[0][0] == ShapeInboard[1][1] &&
                    ShapeInboard[1][1] == ShapeInboard[2][2]) {
                return ShapeInboard[0][0];
            }

            if (ShapeInboard[0][2] != gameShapes.EMPTY &&
                    ShapeInboard[0][2] == ShapeInboard[1][1] &&
                    ShapeInboard[1][1] == ShapeInboard[2][0]) {
                return ShapeInboard[0][2];
            }
        }
        return gameShapes.EMPTY;
    }
}
