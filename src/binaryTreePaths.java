import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 11/14/18.
 */
public class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfsHelper(root, res, new StringBuilder());
        return res;
    }
    public void dfsHelper(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {

            res.add(root.val + "");
        }
        dfsHelper(root.left, res, sb);
        dfsHelper(root.right, res, sb);
        for (int i = 0; i < res.size(); i++) {
            String cur = res.get(i);
            cur = root.val + "->" + cur;
            res.remove(i);
            res.add(cur);
        }
    }
}
