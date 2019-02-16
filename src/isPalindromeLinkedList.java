import java.util.Stack;

/**
 * Created by jianzhe on 9/9/18.
 */
public class isPalindromeLinkedList {
    public boolean isPalindrome(Node node) {
        if (node == null) return true;
        Stack<Integer> stack = new Stack<>();
        Node cur = node;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }
        while (node != null) {
            if (node.value != stack.pop()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
