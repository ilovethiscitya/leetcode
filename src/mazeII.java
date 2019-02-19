import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianzhe on 2/18/19.
 */
public class mazeII {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0,1}};
        int[][] distance = new int[maze.length][maze[0].length];

        for (int[] a : distance) {
            Arrays.fill(a, -1);
        }
        distance[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int[] dir: dirs) {
                int count = distance[c[0]][c[1]];
                int x = c[0];
                int y = c[1];
                while (x + dir[0] >= 0 && x + dir[0] < maze.length && y + dir[1] >= 0 && y + dir[1] < maze[0].length
                        && maze[x + dir[0]][y + dir[1]] != 1) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[x][y] == -1 || distance[x][y] > count) {
                    q.add(new int[]{x,y});
                    distance[x][y] = count;
                }
            }
        }
        return distance[destination[0]][destination[1]];
    }
}
