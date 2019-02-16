import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzhe on 1/11/19.
 */
public class scrambleString {
    public boolean isScramble(String a, String b) {
        Map<String, Boolean> results = new HashMap<>();
        return dfs(a, 0, b, 0, a.length() - 1, results);
    }
    private boolean dfs(String a, int i, String b, int j, int k, Map<String, Boolean> results) {
        String key = i + "_" + j + "_" + k;
        if (results.containsKey(key)) {
            return results.get(key);
        }
        // base case
        if (k == 0) {
            boolean result = a.charAt(i) == b.charAt(j);
            results.put(key, result);
            return result;
        }
        boolean result = false;
        for (int p = 0; p < k; p++) {
            if (dfs(a, i, b, j, p, results)
                    && dfs(a, i + p + 1, b, j + p + 1, k - p + 1,results)
                    || dfs(a, i, b, j + k - p, p, results) && dfs(a, i + p + 1, b, j, k - p - 1, results)) {
                result = true;
                break;
            }
        }
        results.put(key, result);
        return result;
    }
}
