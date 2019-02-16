/**
 * Created by jianzhe on 9/19/18.
 */
public class sortList {
    // selection sort
    public Node sortList(Node head) {
        if (head == null) return head;
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;
        while (cur != null) {
            small = cur;
            smallPre = getSmallPre(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            if (tail == null) {
                head = small;

            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public Node getSmallPre(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if(cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
    // merge sort
    public Node mergeSort(Node head) {
        if (head == null) return head;
        Node pre = null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        Node l1 = mergeSort(head);
        Node l2 = mergeSort(slow);
        return merge(l1, l2);
    }
    public Node merge(Node l1, Node l2) {
        Node l = new Node(0);
        Node p = l;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                p.next = l1;
                l1 = l1.next;
            } else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return l;
    }

}
