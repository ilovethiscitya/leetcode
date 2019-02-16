/**
 * Created by jianzhe on 10/3/18.
 */
public class DesignLinkedList {
    final Node head = new Node(0), tail = new Node(0);
    int len;

    public DesignLinkedList() {
        head.next = tail;
    }

    public int get(int i) {
        if (i >= len) return -1;
        Node node = findPrev(i);
        return node.next.value;
    }

    private Node findPrev(int i) {
        Node cur = head;
        while (i > 0) {
            cur = cur.next;
            i --;
        }
        return cur;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > len) return;
        Node prev = findPrev(index);
        Node next = prev.next;
        prev.next = new Node(val);
        prev.next.next = next;
        len++;
    }

    public void deleteAtIndex(int index) {
        if (len > index) return;;
        Node prev = findPrev(index);
        prev.next = prev.next.next;
        len--;
    }

}
