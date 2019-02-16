import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2/2/19.
 */
public class splitArrayFibonacciSequence {
    public List<Integer> split(String s) {
        List<Integer> ans = new ArrayList<>();
        dfs(s, ans, 0);
        return ans;
    }
    private boolean dfs(String s, List<Integer> ans, int start) {
        if (start == s.length() && ans.size() >= 3) {
            return true;
        }
        for(int i = start; i < s.length(); i++) {
            if (s.charAt(start) == '0' && i > start) break;
            long num = Long.parseLong(s.substring(start, i + 1));
            if (num > Integer.MAX_VALUE) break;
            int size = ans.size();
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) break;
            if (size >= 2 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int)num);
                if (dfs(s, ans, i)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}
