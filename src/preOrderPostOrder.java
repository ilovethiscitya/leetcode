/**
 * Created by jianzhe on 2/19/19.
 */
public class preOrderPostOrder {
    public TreeNode findTree(int[] pre, int [] post) {
        return findNode(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
    private TreeNode findNode(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart + 1]);
        int index = -1;
        for(int i = postStart; i < postEnd; i++) {
            if (pre[preStart + 1] == post[i]) {
                index = i;
                break;
            }
        }
        root.left = findNode(pre, preStart + 1, preStart + index - postStart, post, postStart, index);
        root.right = findNode(pre, preEnd - (postEnd - index - 2), preEnd, post, index + 1, postEnd);
        return root;

    }
}
