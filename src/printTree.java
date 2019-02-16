import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 9/20/18.
 */
public class printTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;
        int depth = getDepth(root);
        int row = depth;
        int col = (int) Math.pow(2, depth)- 1;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            list.add("");
        }
        for (int i = 0; i < row; i++) {
            res.add(new ArrayList<>(list));
        }
        printHelper(root, res, 0, row, 0, col);
        return res;
    }
    private void printHelper(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (root == null) return;
        if (row == totalRows) return;
        int mid = i + (j - i) / 2;
        res.get(row).set(mid, Integer.toString(root.val));
        printHelper(root.left, res, row + 1, totalRows, i, mid - 1);
        printHelper(root.right, res, row + 1, totalRows, mid + 1, j);
    }
    private int getDepth(TreeNode root) {
       if (root == null) return 0;
       return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
     }
}
