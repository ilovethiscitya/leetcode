/**
 * Created by jianzhe on 10/12/18.
 */
public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] map = new int[128];
        int max = 0;
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (j < s.length()) {
            char cur = s.charAt(j);
            map[cur]++;
            if (map[cur] == 1) cnt++;
            if (cur > k) {
                while (cur > k) {
                    char left = s.charAt(i);
                    map[left] --;
                    if (map[left] == 0) cnt--;
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
