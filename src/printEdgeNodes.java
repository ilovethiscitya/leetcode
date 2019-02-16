import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by jianzhe on 9/20/18.
 */
public class printEdgeNodes {
    public void printEdge(TreeNode root) {
        if (root == null) return;
        int height = getHeight(root);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(root, 0, edgeMap);
        for (int i = 0; i < edgeMap.length; i++) {
            System.out.println(edgeMap[i][0]);
        }
        printLeafNotInMap(root, 0, edgeMap);
        for (int i = 0; i < edgeMap.length; i++) {
            System.out.println(edgeMap[i][1]);
        }
    }
    private void printLeafNotInMap(TreeNode root, int l, TreeNode[][] m) {
        if (root == null) return;
        if (root.left == null && root.right == null && root != m[l][0] && root != m[l][1] ) {
            System.out.println(root.val);
        }
        printLeafNotInMap(root.left, l + 1, m);
        printLeafNotInMap(root.right, l + 1, m);
    }
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    private void setEdgeMap(TreeNode root, int height, TreeNode[][] edgeMap) {
        if (root == null) return;
        edgeMap[height][0] = edgeMap[height][0] == null ? root : edgeMap[height][0];
        edgeMap[height][1] = root;
        setEdgeMap(root.left, height + 1, edgeMap);
        setEdgeMap(root.right, height + 1, edgeMap);
    }
}
