import java.util.Stack;

/**
 * Created by jianzhe on 10/13/18.
 */
public class minimumAddParenthesesValid {
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) stack.push(chars[i]);
            else if (chars[i] == ')'){
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }

            } else if (chars[i] == '(') {
                stack.push(chars[i]);
            }
        }
        return stack.size();
    }
}
