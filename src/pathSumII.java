import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 9/27/18.
 */
public class pathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, sum, new ArrayList<>(), res);
        return res;
    }
    //慎用return, 因为一旦return之后整枝就没有了
    public void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root == null|| sum < 0) return;
        list.add(root.val);
        sum -= root.val;
        if (sum == 0) {
                res.add(new ArrayList<>(list));
        }
        helper(root.left, sum, list, res);
        helper(root.right, sum, list, res);
        list.remove(list.size() - 1);
    }
}
