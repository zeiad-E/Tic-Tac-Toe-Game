package backend;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ObserverGame {

    public void registerObserver(GameEngin gameEngin) {
        JPanel panel = new JPanel();
        String title = "Game Over";
        if (gameEngin.getboard().isFull()) {
            //System.out.println("The game is full\nPlease Play Again");
            JOptionPane.showMessageDialog(panel, "Game is fully", title, JOptionPane.INFORMATION_MESSAGE);
        } else if (gameEngin.getboard().hasWinner()) {
            if (gameEngin.getWinner() == gameShapes.X)
                //System.out.println("O wins");
                JOptionPane.showMessageDialog(panel, "O Player is the winner", title,
                        JOptionPane.INFORMATION_MESSAGE);
            else if (gameEngin.getWinner() == gameShapes.O)
                //System.out.println("X wins");
                JOptionPane.showMessageDialog(panel, "X Player is the winner", title,
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
