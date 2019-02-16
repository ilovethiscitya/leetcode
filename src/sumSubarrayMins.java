import java.util.Stack;

/**
 * Created by jianzhe on 2/6/19.
 */
public class sumSubarrayMins {
    public int sumS(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        int sum = 0;
        int mod = (int)(1e9 + 7);
        for(int i = 0; i < A.length; i++) {
            // 保证栈顶是最大的
            while(stack.peek() != -1 && A[stack.peek()] > A[i]) {
                int index = stack.pop();
                sum -= (index - stack.peek()) * A[index];
            }
            // System.out.println("sum is" + sum);
            sum += A[i] * (i - stack.peek());
            res += sum;
            res %= mod;
            stack.push(i);
        }
        return (int) res;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        sumSubarrayMins s = new sumSubarrayMins();
        int res = s.sumS(nums);
        System.out.println(res);
    }
}
