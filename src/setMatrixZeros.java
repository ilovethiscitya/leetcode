import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 10/26/18.
 */
public class setMatrixZeros {
    //规定方向的bfs?
    public void setZeroes(int [][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        List<int[]> candidate = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    candidate.add(new int[]{i,j});
                }
            }
        }

        for (int i = 0; i < candidate.size(); i++) {
            int[] points = candidate.get(i);
            setRowZero(matrix, points[0]);
            setColZero(matrix, points[1]);
        }
    }
    private void setRowZero(int[][] matrix, int start) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[start][i] = 0;
        }
    }
    private void setColZero(int[][] matrix, int start) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][start] = 0;
        }
    }

}
