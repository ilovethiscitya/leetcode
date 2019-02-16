import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianzhe on 9/21/18.
 */
public class SerializeDeseializeTree {
//    Queue<String> queue;
    public String serialize(TreeNode root) {
        if (root == null) return "#!";
        String res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }
    public TreeNode deserialize(String data) {
        String[] values = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconstruct(queue);
    }
    public TreeNode reconstruct(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconstruct(queue);
        head.right = reconstruct(queue);
        return head;

    }
}
