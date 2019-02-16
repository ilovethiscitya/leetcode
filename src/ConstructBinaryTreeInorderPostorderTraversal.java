import java.util.HashMap;

/**
 * Created by jianzhe on 9/27/18.
 */
public class ConstructBinaryTreeInorderPostorderTraversal {
//    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
//        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
//    }
//    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map) {
//        if (ps > pe || is > ie) return null;
//        TreeNode root = new TreeNode(postorder[pe]);
//        int ri = map.get(postorder[pe]);
//        TreeNode leftChild = buildTreePostIn(inorder, is, ri - 1, postorder, ps, ps + ri-is-1, map);
//        TreeNode rightChild = buildTreePostIn(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, map);
//        root.left = leftChild;
//        root.right = rightChild;
//        return root;
//    }

}
