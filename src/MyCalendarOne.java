/**
 * Created by jianzhe on 10/3/18.
 */
public class MyCalendarOne {
    class Node {
        int start;
        int end;
        Node left;
        Node right;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }

        public boolean insert(int start, int end) {
            if (this.end <= start) {
                if (this.right == null) {
                    this.right = new Node(start, end);
                    return true;
                } else {
                    return this.right.insert(start, end);
                }
            } else if (this.start >= end) {
                if (this.left == null) {
                    this.left = new Node(start, end);
                    return true;
                } else {
                    return this.left.insert(start, end);
                }
            } else {
                return false;
            }
        }
    }
    Node root;
    public MyCalendarOne() {
        this.root = null;
    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }
        return root.insert(start, end);
    }


}
