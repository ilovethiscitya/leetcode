/**
 * Created by jianzhe on 10/27/18.
 */
public class wordSearch {
    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordChar[0] == board[i][j]) {
                    if (exist(board, i, j, wordChar, 0, used)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
    private boolean exist(char[][] board, int i, int j, char[] wordChar, int index, boolean[][] used) {
        if (index == wordChar.length) return false;
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (used[i][j]) return false;

        if (wordChar[index] != board[i][j]) return false;
        if (index == wordChar.length - 1 && wordChar[index] == board[i][j]) return true;
        used[i][j] = true;
        boolean a1 = exist(board, i + 1, j, wordChar, index + 1, used);

        boolean a2 = exist(board, i - 1, j, wordChar, index + 1, used);

        boolean a3 = exist(board, i, j + 1, wordChar, index + 1, used);

        boolean a4 = exist(board, i, j - 1, wordChar, index + 1, used);
        if (a1 || a2 || a3 || a4) return true;
        used[i][j] = false;


        return false;
    }
}
