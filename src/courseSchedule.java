import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianzhe on 9/25/18.
 */
public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[0])) {
                map.put(pre[0], new ArrayList<>());
            }
            map.get(pre[0]).add(pre[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] stacked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfsHelper(map, visited, stacked, i)) return false;
        }
        return true;
    }
    private boolean dfsHelper(Map<Integer, List<Integer>> map, boolean[] visited, boolean[] stacked, int i) {
        if (stacked[i]) return true;
        if (visited[i]) return false;
        List<Integer> values = map.get(i);
        visited[i] = true;
        for (int j = 0; j < values.size(); j++) {
            if (!dfsHelper(map, visited, stacked, j)) return false;
        }
        visited[i] = false;
        stacked[i] = true;
        return true;

    }
}
