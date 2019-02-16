import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jianzhe on 10/12/18.
 * Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingC {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
            }
        }
        return max;
    }
}
