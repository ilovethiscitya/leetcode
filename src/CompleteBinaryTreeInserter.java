import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 10/6/18.
 */
public class CompleteBinaryTreeInserter {
    List<TreeNode> tree;
    public CompleteBinaryTreeInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).left != null) tree.add(tree.get(i).left);
            if (tree.get(i).right != null) tree.add(tree.get(i).right);
        }
    }
    public int insert(int v) {
        int N = tree.size();
        TreeNode node =  new TreeNode(v);
        tree.add(node);
        if (N%2 == 1)
            tree.get((N - 1) / 2).left = node;
        else
            tree.get((N - 1) / 2).right = node;
        return tree.get((N - 1) / 2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
}
