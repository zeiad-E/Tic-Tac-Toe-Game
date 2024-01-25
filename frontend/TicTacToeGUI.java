package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons;
    private boolean playerX;

    public TicTacToeGUI() {
        super("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        playerX = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                add(buttons[i][j]);
            }
        }
    }

    // New method to update the GUI based on the backend data
    public void updateGUI(char[][] board) {
        if (board.length != 3 || board[0].length != 3) {
            throw new IllegalArgumentException("Invalid board dimensions");
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    buttons[i][j].setIcon(new ImageIcon("x.png"));
                } else if (board[i][j] == 'O') {
                    buttons[i][j].setIcon(new ImageIcon("o.png"));
                } else {
                    buttons[i][j].setIcon(null);
                }
                buttons[i][j].setDisabledIcon(buttons[i][j].getIcon());
                buttons[i][j].setEnabled(false);
            }
        }
    }

    
}
