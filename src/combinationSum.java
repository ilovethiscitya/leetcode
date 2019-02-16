import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianzhe on 2/1/19.
 */
public class combinationSum {
    public List<List<Integer>> sum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, res, path, target, 0);
        return res;

    }
    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> path, int target, int pos) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, res, path, target - candidates[i], i );
            path.remove(path.size() - 1);
        }
    }
}
