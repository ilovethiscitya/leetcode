import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 9/20/18.
 */
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        return genTree(1, n);
    }
    public List<TreeNode> genTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for (int i = start; i < end; i++) {
            left = genTree(start, i - 1);
            right = genTree(i + 1, end);
            for (TreeNode lnodes : left) {
                for (TreeNode rnodes : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnodes;
                    root.right = rnodes;
                    list.add(root);
                }
            }
        }

    return list;
    }
}
