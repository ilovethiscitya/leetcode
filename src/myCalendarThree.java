
public class myCalendarThree {
    class Node {
        int start, end, k;
        Node left, mid, right;
        public Node(int start, int end, int k) {
            this.start = start;
            this.end = end;
            this.k = k;
        }
    }
    public Node node;
    public int ans = 1;
    public myCalendarThree() {
        node = null;
    }
    public int book(int start, int end) {
        node = search(node, start, end, 1);
        return ans;
    }
    public Node search(Node node, int start, int end, int dul) {
        if (node == null) {
            ans = Math.max(dul, ans);
            return new Node(start, end, dul);
        }
        // [10,20] c[10,40]
        if (start >= node.start && end <= node.end) {
            node.mid = search(node.mid, start, end, dul + 1);
        } else if (end <= node.start) {
            node.left = search(node.left, start, end, dul);
        } else if (start >= node.end) {
            node.right = search(node.right, start, end, dul);
        } else if (end > node.start && end <= node.end) {
            node.left = search(node.left, start, node.start, dul);
            node.mid = search(node.mid, node.start, end, dul + 1);
        } else if (start >= node.start && start < node.end) {
            node.mid = search(node.mid, start, node.end, dul + 1);
            node.right = search(node.right, node.end, end, dul);
        } else {
            node.left = search(node.left, start, node.start, dul);
            node.mid = search(node.mid, node.start, node.end, dul + 1);
            node.right = search(node.right, node.end, end, dul);
        }
        return node;
    }
}
