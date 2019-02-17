public class maximumMinimumPath {
    int min;
    int max;
    int row;
    int col;
    public int maxMinPath(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(grid, min, 0, 0);
        return max;
    }
    private void dfs(int[][] grid, int min, int i, int j) {
        if(i == row - 1 && j == col - 1) {
            min = Math.min(min, grid[i][j]);
            max = Math.max(max, min);
            return;
        }
        min = Math.min(min, grid[i][j]);
        if(i + 1 < grid.length) {
            dfs(grid, min, i - 1, j);
        }
        if(j + 1 < grid[0].length) {
            dfs(grid, min, i, j + 1);
        }
    }
}