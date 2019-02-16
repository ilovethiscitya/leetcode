import java.util.Stack;

/**
 * Created by jianzhe on 10/31/18.
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
    }
    public boolean hasNext() {
        return stack.isEmpty();
    }
    public int next() {
        TreeNode nextNode = stack.pop();
        int value = nextNode.val;
        if (nextNode.right != null) {
            nextNode = nextNode.right;
            while (nextNode.left != null) {
                stack.push(nextNode);
                nextNode = nextNode.left;
            }
        }
        return value;
    }
}
