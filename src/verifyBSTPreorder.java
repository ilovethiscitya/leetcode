import java.util.Stack;

/**
 * Created by jianzhe on 2/18/19.
 */
public class verifyBSTPreorder {
    public boolean isBSTPreorder(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < low) return false;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                low = stack.pop();
            }
            stack.push(nums[i]);
        }
        return true;
    }
}
