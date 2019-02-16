import java.util.List;
import java.util.Stack;

/**
 * Created by jianzhe on 10/13/18.
 */
public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        class Node {
            int index;
            int start_time;
            int children_time = 0;
            public Node(int index, int start_time) {
                this.index = index;
                this.start_time = start_time;
            }
        }
        int[] res = new int[n];
        String first = logs.get(0);
        Stack<Node> stack = new Stack<>();
        String[] firstNode = first.split(":");
        int idx = 0;
        Node node = new Node(Integer.valueOf(firstNode[0]), Integer.valueOf(firstNode[2]));
        stack.push(node);
        for (int i = 1; i < logs.size(); i++) {
            String[] cur = logs.get(i).split(":");
            if (cur[1].equals("start")) {
                Node newNode = new Node(Integer.valueOf(cur[0]), Integer.valueOf(cur[2]));
                stack.push(newNode);
            } else {
                Node curr = stack.pop();
                int index = Integer.valueOf(cur[0]);
                int childTime = Integer.valueOf(cur[2]) - curr.start_time + 1 - curr.children_time;
                res[index] += childTime;
                Node peek = stack.isEmpty() ? null : stack.peek();
                if (peek != null) {
                    peek.children_time += Integer.valueOf(cur[2]) - curr.start_time + 1;
                }
            }

        }
        return res;
    }
}
