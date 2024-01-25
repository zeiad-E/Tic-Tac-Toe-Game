package frontend;

import javax.swing.*;

import backend.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons;
    private Player playerMode;
    private GameEngin g = new GameEngin();
    private ObserverGame o = new ObserverGame();

    public TicTacToeGUI() {
        super("Tic Tac Toe");

        Object[] options = { "One Player", "Two Players" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Select Game Mode:",
                "Game Mode Selector",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if (choice == 0) {
            playerMode = new OnePlayer(g, o);
        } else {
            playerMode = new TwoPlayers(g, o);
        }

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);

                // Add ActionListener to each button
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));

                add(buttons[i][j]);
            }
        }
        o.registerObserver(g);
    }

    // ActionListener for the buttons
    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isGameOver = g.gameOver();
            if (!isGameOver) {
                playerMode.play(row, col);
                updateGUI(g.getboard());
            }
            // isGameOver = g.gameOver();
            else if (isGameOver && g.getboard().hasWinner()) {
                JPanel panel = new JPanel();
                String title = "Game Over";
                if (g.getWinner() == gameShapes.X) {
                    JOptionPane.showMessageDialog(panel, "O Player is the winner", title,
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (g.getWinner() == gameShapes.O) {
                    JOptionPane.showMessageDialog(panel, "X Player is the winner", title,
                            JOptionPane.INFORMATION_MESSAGE);
                }
                // updateGUI(g.getboard());
            } else if (g.getboard().isFull()) {
                JPanel panel = new JPanel();
                String title = "Game Over";
                JOptionPane.showMessageDialog(panel, "Game is fully", title, JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // New method to update the GUI based on the backend data
        public void updateGUI(backGround board) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (g.getboard().getPiece(i, j).equals(gameShapes.X)) {
                        buttons[i][j].setIcon(new ImageIcon("frontend/x.png"));
                    } else if (g.getboard().getPiece(i, j).equals(gameShapes.O)) {
                        buttons[i][j].setIcon(new ImageIcon("frontend/o.png"));
                    } else {
                        buttons[i][j].setIcon(null);
                    }
                    buttons[i][j].setDisabledIcon(buttons[i][j].getIcon());
                    // buttons[i][j].setEnabled(false);
                }
            }
        }
    }
}