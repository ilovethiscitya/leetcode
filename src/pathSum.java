import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 11/13/18.
 */
public class pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return dfs(root,sum);
    }
    private List<List<Integer>> dfs(TreeNode node, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(node.left == null && node.right == null) {
            if (sum == node.val) {
                List<Integer> list = new ArrayList<>();
                list.add(sum);
                result.add(list);
                return result;
            }
        }
        List<List<Integer>> childrenResult = new ArrayList<>();
        if (node.left != null) {
            childrenResult.addAll(dfs(node.left, sum - node.val));
        }
        if (node.right != null) {
            childrenResult.addAll(dfs(node.right, sum - node.val));
        }
        for(List<Integer> list : childrenResult) {
            list.add(0, node.val);
            result.add(list);
        }
        return result;
    }

}
