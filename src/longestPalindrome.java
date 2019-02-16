/**
 * Created by jianzhe on 2/1/19.
 */
public class longestPalindrome {
    public int longestPalin(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int[] cur = new int[s.length() + 1];
        int[] pre = new int[s.length() + 1];
        int n = s.length();
        int result = 0;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                if (i == j) {
                    cur[j] = 1;
                } else if(j - i == 1) {
                    cur[j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        cur[j] = pre[j - 1] + 2;
                    } else {
                        cur[j] = Math.max(cur[j - 1], pre[j]);
                    }
                }
                result = Math.max(result, cur[j]);
            }
        }
        int[] temp = cur;
        cur = pre;
        pre = temp;
        return result;
    }

}
