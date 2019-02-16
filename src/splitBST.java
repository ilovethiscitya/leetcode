/**
 * Created by jianzhe on 2/7/19.
 */
public class splitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode[] splited;
        if (root.val <= V) {
            splited = splitBST(root.right, V);
            root.right = splited[0];
            splited[0] = root;
        } else {
            splited = splitBST(root.left, V);
            root.left = splited[1];
            splited[1] = root;
        }
        return splited;
    }
}
