import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianzhe on 1/27/19.
 */
public class makingALargeLand {
    private final static int UNMARKED = -2;
    private final static int LAND = 1;
    private final static int WATER = 0;
    public int largestLand(int[][] grid) {
        if(grid[0].length == 0 || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] colors = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                colors[i][j] = UNMARKED;
            }
        }
        int maxArea = 0;
        List<Integer> colorToArea = new ArrayList<>();
        int curColor = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == WATER) {
                    colors[i][j] = -1;
                } else if(grid[i][j] == LAND && colors[i][j] == UNMARKED) {
                    int area = dfs(grid, i, j, colors, curColor);
                    colorToArea.add(area);
                    maxArea = Math.max(maxArea, area);
                    curColor++;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == WATER) {
                    int result = 1;
                    Set<Integer> colorSet = new HashSet<>();
                    if(i - 1 >= 0 && colors[i - 1][j] >= 0 ) {
                        colorSet.add(colors[i - 1][j]);
                    }
                    if(i + 1 < n && colors[i + 1][j] >= 0) {
                        colorSet.add(colors[i + 1][j]);
                    }
                    if(j - 1 >= 0 && colors[i][j - 1] >= 0) {
                        colorSet.add(colors[i][j - 1]);
                    }
                    if(j + 1 < n && colors[i][j + 1] >= 0) {
                        colorSet.add(colors[i][j + 1]);
                    }
                    for(int color : colorSet) {
                        result += colorToArea.get(color);
                    }
                    maxArea = Math.max(maxArea, result);
                 }
            }

        }
        return maxArea;

    }
    private int dfs(int[][] grid, int i, int j, int[][] color, int curColor) {
        if(color[i][j] != UNMARKED) {
            return 0;
        }
        int result = 0;
        if(i - 1 >= 0 && grid[i - 1][j] >= grid[i][j]) {
            result += dfs(grid, i - 1, j, color, curColor);
        }
        if(i + 1 < grid.length && grid[i + 1][j] >= grid[i][j]) {
            result += dfs(grid, i + 1, j, color, curColor);
        }
        if(j - 1 >= 0 && grid[i][j - 1] >= grid[i][j]) {
            result += dfs(grid, i, j - 1, color, curColor);
        }
        if(j + 1 >= 0 && grid[i][j + 1] >= grid[i][j]) {
            result += dfs(grid, i, j + 1, color, curColor);
        }
        return result;
    }
}
