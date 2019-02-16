/**
 * Created by jianzhe on 11/1/18.
 */
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antidiagonal;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }
        if (col + row + 1 == (cols.length)) {
            antidiagonal += toAdd;
        }
        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antidiagonal) == size) {
            return player;
        }
        return 0;
    }
}
