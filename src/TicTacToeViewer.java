import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private TicTacToe t;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    public TicTacToeViewer(TicTacToe t)
    {
        this.t = t;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        // draws numbers
        g.setFont(new Font("SERIF", Font.PLAIN, 30));
        for (int i = 0; i < 3; i++)
        {
            g.drawString(Integer.toString(i + 1), (Square.WIDTH * i) + Square.STARTING_POINT + 40, 180);
        }
        for (int i = 0; i < 3; i++)
        {
            g.drawString(Integer.toString(i + 1), 170, (Square.WIDTH * i) + Square.STARTING_POINT + 60);
        }

        // draws squares
        Square[][] squares = t.getBoard();
        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[0].length; j++)
            {
                squares[i][j].draw(g);
            }
        }

        // displays results (tie or winner)
        if (t.getGameOver())
        {
            if (t.checkTie())
            {
                g.drawString("It's a tie!", 250, 600);
            }
            else
            {
                g.drawString(t.getWinner() + " wins!", 250, 600);
            }
        }
    }
}
