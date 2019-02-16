import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 1/29/19.
 */
public class eventualSafe {
    public List<Integer> eventualSafe(int[][] edges) {
        List<Integer> res = new ArrayList<>();
        Boolean[] result = new Boolean[edges.length];
        boolean[] visitedNode = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++) {
            if(dfs(edges, i, result, visitedNode)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int[][] edges, int i, Boolean[] result, boolean[] visitedNode) {
        if (result[i] != null) {
            return result[i];
        }
        if (visitedNode[i]) {
            return false;
        }
        boolean res = true;
        for(int child : edges[i]) {
            res &= dfs(edges, child, result, visitedNode);
        }
        return res;
    }
}
