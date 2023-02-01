import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    public static final int WIDTH = 100;
    public static final int STARTING_POINT = 200;

    private TicTacToeViewer viewer;
    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    private Image o_image;
    private Image x_image;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer viewer) {
        this.row = row;
        this.col = col;
        this.viewer = viewer;
        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g)
    {
        // x and y of the specific Square
        int x = (WIDTH * col) + STARTING_POINT;
        int y = (WIDTH * row) + STARTING_POINT;
        // draw the square
        g.drawRect(x, y, WIDTH, WIDTH);
        // fill in green if winning square
        if (this.isWinningSquare)
        {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, WIDTH, WIDTH);
        }
        // if square has an X
        if (this.marker.equals(TicTacToe.X_MARKER))
        {
            g.drawRect(x, y, WIDTH, WIDTH);
            x_image = new ImageIcon("Resources/X.png").getImage();
            g.drawImage(x_image, x, y, WIDTH, WIDTH, viewer);
        }
        // if square has an O
        else if (this.marker.equals(TicTacToe.O_MARKER))
        {
            g.drawRect(x, y, WIDTH, WIDTH);
            o_image = new ImageIcon("Resources/O.png").getImage();
            g.drawImage(o_image, x, y, WIDTH, WIDTH, viewer);
        }
    }

}
