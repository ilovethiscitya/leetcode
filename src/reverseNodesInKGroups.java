import java.util.Stack;

/**
 * Created by jianzhe on 9/8/18.
 */
public class reverseNodesInKGroups {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;
        Node curr = head;
        int count = 0;
        while (curr != null && count == k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr.next, k);
            while (count-- > 0) {
                Node temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        return head;
    }
//    public Node reverseKGroup(Node head, int k) {
//        Stack<Integer> stack = new Stack<>();
//        Node index  = head;
//        while (index != null) {
//            Node temp = index;
//            while (stack.size() < k && temp != null) {
//                stack.push(temp.value);
//                temp = temp.next;
//            }
//            if (stack.size() == k) {
//                while (index != null && stack.size() > 0) {
//                    index.value = stack.pop();
//                    index = index.next;
//
//                }
//            } else {
//                index = null;
//
//            }
//        }
//        return head;
//    public Node reverseKGroup(Node head, int k) {
//        if(k == 1) return head;
//        return helper(head, k)[0];
//    }
//    public Node[] helper(Node head, int k) {
//        Node p = head;
//        while (k-- != 0) {
//            p = p.next;
//        }
//        if (k== 0) {
//            Node next = p.next;
//            Node newHead = null;
//            while (head != p) { //这里好诡异 怎么翻转某个区间的链表？
//                Node tmp = head.next;
//                head.next = newHead;
//                newHead = head;
//                head = tmp;
//            }
//
//            head.next = helper(next, k)[1];
//            return new Node[]{head, newHead};
//        } else {
//            return new Node[]{head, head};
//        }
//    }
}
