import java.util.HashSet;

/**
 * Created by jianzhe on 11/1/18.
 */
public class removeDuplicateLinkedList {
    public void removeDuplicate(Node head) {
        HashSet<Integer> set = new HashSet<>();
        if (head.next == null) return;
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            int curVal = cur.value;
            if (set.contains(curVal)) {
                prev.next = cur.next;
            } else {
                set.add(curVal);
                prev = cur;
            }
            cur = cur.next;
        }
    }
}
