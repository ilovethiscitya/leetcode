import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianzhe on 10/30/18.
 */
public class palindromeSubstring {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        //以s.charAt(i)为中间向两边扩散
        // 要分奇偶数进行讨论
        int start = 0;
        int end = 0;
        int length = s.length();
        int sum = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            start = i;
            end = i;
            while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
//                set.add(s.substring(start, end));
                sum++;
                start--;
                end++;
            }
        }
         start = 0;
        end = 0;
        for (int i = 1; i < s.length(); i++) {
            start = i - 1;
            end = i;
            while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
//                set.add(s.substring(start, end));
                sum++;
                start--;
                end++;
            }
        }
        return sum;
    }
}
