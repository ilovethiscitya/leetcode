import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by jianzhe on 2/18/19.
 */
public class KminimumDistance {
    public int minimumDistance(int numRows, int numColumns, int[][] lots) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[numRows][numColumns];
        int level = 0;
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                if (curX + 1 < numRows && lots[curX + 1][curY] == 9) {
                    return level + 1;
                }
                if (curY + 1 < numColumns && lots[curX][curY + 1] == 9) {
                    return level + 1;
                }
                if (curX + 1 < numRows && lots[curX + 1][curY] == 1) {
                    if (!visited[curX + 1][curY]) {
                        visited[curX + 1][curY] = true;
                        queue.add(new int[]{curX + 1, curY});
                    }

                }
                if (curY + 1 < numColumns && lots[curX][curY + 1] == 1) {
                    if (!visited[curX][curY + 1]) {
                        visited[curX][curY + 1] = true;
                        queue.add(new int[]{curX, curY + 1});
                    }

                }
            }

            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int numRows = 3;
        int numColumns = 3;
        int[][] lots = {{1,0,0}, {1,0,0}, {1,9,1}};
        KminimumDistance k = new KminimumDistance();
        int res = k.minimumDistance(3,3,lots);
        System.out.println(res);

        int[][] lots2 = {{1,1,1,1}, {0,1,1,1}, {0,1,0,1},{1,1,9,1},{0,0,1,1}};
        int res2 = k.minimumDistance(5,4,lots2);
        System.out.println(res2);
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1,2});
        set.add(new int[]{1,2});
        System.out.println(set.size());
    }
}
