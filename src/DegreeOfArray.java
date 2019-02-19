import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2/18/19.
 */
public class DegreeOfArray {
    public List<Integer> findShortestSubArray(int[][] edges) {
        int n = edges.length;
        Boolean[] result = new Boolean[n];
        boolean[] visitedNode = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (dfs(edges, i, result, visitedNode)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int[][] edges, int i, Boolean[] results, boolean[] visitedNode) {
        if (results[i] != null) {
            return results[i];
        }
        if (visitedNode[i]) {
            return false;
        }
        visitedNode[i] = true;
        boolean result = true;
        for (int j = 0; j < edges[i].length; j++)
     {
        result &= dfs(edges, edges[i][j], results, visitedNode);
     }
     results[i] = result;
        return result;
    }
}
