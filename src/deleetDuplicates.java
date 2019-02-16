/**
 * Created by jianzhe on 9/19/18.
 */
public class deleetDuplicates {
    public Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) return head;
        Node cur = head;
        Node nextNode = null;
        while (cur.next != null) {
            nextNode = cur.next;
            if (nextNode.value != cur.value) {
                cur.next = nextNode.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
