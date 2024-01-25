package backend;

import java.util.Scanner;

public class testBackend {
    public static void main(String[] args) {
        GameEngin g = new GameEngin();
        ObserverGame o = new ObserverGame();
        // GameEngin g = new GameEngin();  
        // ObserverGame o=new ObserverGame();
        // while (!g.gameOver()) {
        // try (Scanner s = new Scanner(System.in)) {
        // // System.out.println("efefef");
        // GamePostion pos = new GamePostion(row, col);
        // g.setPlace(pos);
        // }
        // o.registerObserver(g);
        // }
        // TwoPlayers twoPlayers = new TwoPlayers(g, o);
        // for(int i=0;i<9;i++){
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the index: ");
        // int row = sc.nextInt();
        // int col = sc.nextInt();
        // twoPlayers.play(row,col);
        // }
        OnePlayer onePlayers = new OnePlayer(g, o);
        for (int i = 0; i < 9; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the index: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            onePlayers.play(row, col);
            if (g.gameOver())
                break;
        }
        // twoPlayers.play(i);
      
import frontend.TicTacToeGUI;

public class testBackend {
    public static void main(String[] args) {
        
        new TicTacToeGUI().setVisible(true);
        TwoPlayers twoPlayers = new TwoPlayers();

    }
}
