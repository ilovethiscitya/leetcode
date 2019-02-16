/**
 * Created by jianzhe on 9/9/18.
 */
public class reverseLinkedListII {
    public Node reverseLinkedListII(Node head, int m, int n) {
        if (head == null) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        while (pre.next != null && m != 1) {
            pre = pre.next;
            m--;
        }
        Node start = pre.next;
        Node then = start.next;
        while (n - m != 0) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            n++;
        }
        return dummy.next;
    }
}
