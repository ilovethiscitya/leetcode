/**
 * Created by jianzhe on 9/19/18.
 */
public class copyWithRandom {
    public Node copyListRandom(Node head) {
        if (head == null) return head;
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            Node newNext = new Node(cur.value);
            cur.next = newNext;
            newNext.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
//            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
