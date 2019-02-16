import java.util.Stack;

/**
 * Created by jianzhe on 2018/7/12.
 */
public class addList {
    public Node addlist(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.value);
            head2 = head2.next;
        }
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int ca = 0;
        Node head = null;
        Node pre = null;
        while (!s1.isEmpty() || !s2.isEmpty() ) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            head = new Node(n % 10);
            ca = n / 10;
            head.next = pre;
            pre = head;
        }
        if (ca == 1) {
            pre = head;
            head = new Node(1);
            head.next = pre;
        }
        return head;
    }
}

