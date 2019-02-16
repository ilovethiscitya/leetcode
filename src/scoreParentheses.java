import java.util.Stack;

/**
 * Created by jianzhe on 2/2/19.
 */
public class scoreParentheses {
    public int score(String S) {
        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(0);
            } else {
                int cur = 0;
                while (stack.peek() != 0) {
                    cur += stack.pop();
                }
                stack.pop();
                stack.push(cur == 0 ? 1 : cur * 2);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "(())()";
        scoreParentheses t = new scoreParentheses();
        int res = t.score(s);
        System.out.println(res);

    }
}
