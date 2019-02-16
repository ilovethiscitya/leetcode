/**
 * Created by jianzhe on 1/31/19.
 */
public class MaxIncreaseKeepSkyLinke {
    private int maxIncrease(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[i] = Math.max(col[i], grid[i][j]);
            }
        }
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                res += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return res;
    }
}
