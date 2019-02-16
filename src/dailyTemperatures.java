import java.util.Stack;

/**
 * Created by jianzhe on 10/13/18.
 */
public class dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
               int cur = T[i];
               while (!stack.isEmpty() && cur > T[stack.peek()]) {
                    int prev = stack.pop();
                    res[prev] = i - prev ;
               }
                stack.push(i);
        }
        return res;
    }
}
