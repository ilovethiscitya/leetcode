/**
 * Created by jianzhe on 9/23/18.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        // 意义是该字母连续存在了多少个
        // 把其中某一个换掉会发生什么事情要考虑到
        int max = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            while (end < s.length() && isValid(s.charAt(end),count, k)) {
                count[s.charAt(end) - 'A']++;
                end++;
            }
            max = Math.max(max, end - start);
            count[s.charAt(start) - 'A']--;
            start++;
        }
        return max;
    }
    private boolean isValid(char c, int[] count, int k) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, c - 'A' == i ? count[i] + 1 : count[i]);
            sum += count[i];
        }
        return sum + 1 - max <= k;
    }
}
