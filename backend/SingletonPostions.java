package backend;

public class SingletonPostions {
    // // private gameShapes[][] gShapes;
    // // private static SingletonPostions postion=new
    // private static GameEngin g;
    // public static GamePostion getinstance(int row, int col) {
    //     GamePostion pos=new GamePostion(row, col);
    //     backGround bGround = FlyWeightFactory.getbackGround(pos);
    //     System.out.println("ddwdw");
    //     if (bGround.getPiece(row, col) == gameShapes.EMPTY)
    //         g.getboard().setPiece(row, col, g.getcurrentPlayer());
    //     pos = new GamePostion(row, col);
    //     return pos;
    //     // if ((row > 0 && row < 3) || (col > 0 && col < 3)) {
    //     // } else {
    //     // System.out.println("Error: Invalid position!");
    //     // }
    //     // return null;
    // }
    private static GamePostion gamePositionInstance;

    private SingletonPostions() {
    }

    public static GamePostion getInstance() {
        if (gamePositionInstance == null) {
            gamePositionInstance = new GamePostion(gamePositionInstance.getRow(),gamePositionInstance.getCol());
        }
        return gamePositionInstance;
    }
}
