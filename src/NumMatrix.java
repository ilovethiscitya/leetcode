import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jianzhe on 10/31/18.
 */
public class NumMatrix {
    HashMap<Integer, int[]> indexToRow;
    public NumMatrix(int[][] matrix) {
        indexToRow = new HashMap<>();
        int[] row = new int[matrix[0].length];
        indexToRow.put(-1, row);
        for (int i = 0; i < matrix.length; i++) {
            row = Arrays.copyOf(row, row.length);
            for (int j = 0; j < matrix[0].length; j++) {
                row[j] += matrix[i][j];
            }
            indexToRow.put(i, row);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        int[] top = indexToRow.get(row1 - 1);
        int[] down = indexToRow.get(row2);
        for (int i = col1; i <= col2; i++) {
            System.out.println(down[i]);
            System.out.println(top[i]);
            sum += down[i] - top[i];
        }
        return sum;
    }
}
