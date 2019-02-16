import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jianzhe on 10/27/18.
 */
public class ConstructBinaryTreeInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        Map<Integer, Integer> valueToIndexMapping = new HashMap<>();
        for(int i = 0; i < preorder.length; i++) {
            valueToIndexMapping.put(preorder[i], i);
        }
        return constructTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, valueToIndexMapping);
    }
    public TreeNode constructTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int ri = map.get(preorder[ps]);
        root.left = constructTree(preorder, inorder, ps + 1, ps + ri - is, is, ri - 1, map);
        root.right = constructTree(preorder, inorder, pe - ie + ri + 1, pe, ri + 1, ie, map);
        return root;
    }
}
