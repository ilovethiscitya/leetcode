import java.util.Stack;

/**
 * Created by jianzhe on 11/4/18.
 */
public class simplyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int start = 1;
        for(int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if(c != '/') {
                addToStack(stack, path, start, i);
                start = i + 1;
            }
        }
        if (path.charAt(path.length() - 1) != '/') {
            addToStack(stack, path, start, path.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        for(String s : stack) {
            sb.append("/" + s);
        }
        return sb.toString();
    }
    private void addToStack(Stack<String> stack, String s, int start, int end) {
        String prev = s.substring(start, end);
        if (prev.equals(".")) {
            return;
        } else if (prev.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push(prev);
        }
    }
}
