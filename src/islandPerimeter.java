/**
 * Created by jianzhe on 1/17/19.
 */
public class islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int isLands = 0;
        int neighbor = 0;
        for (int i= 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    isLands++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        neighbor++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return isLands * 4 + neighbor * 2;
    }
}
