/**
 * Created by jianzhe on 2/1/19.
 */
public class interleavingString {
    public boolean isInterleave(String s1, String s2, String target) {
        if(s1.length() + s2.length() != target.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        if(m > n) {
            return isInterleave(s2, s1, target);
        }
        boolean[] result = new boolean[m + 1];
        for(int i = n; i >= 0; i--) {
            for(int j = m; j >= 0; j--) {
                if(i == n && j == m) {
                    result[j] = true;
                } else if(i == n) {
                    result[j] = (s2.charAt(j) == target.charAt(i + j)) && result[j + 1];
                } else if(j == m) {
                    result[j] =(s1.charAt(i) == target.charAt(i + j)) && result[j];
                } else {
                    if(s1.charAt(i) == target.charAt(i + j) && s2.charAt(j) == target.charAt(i + j)) {
                        result[j] = result[j] || result[j + 1];
                    } else if(s1.charAt(i) == target.charAt(i + j)) {
                        result[j] = result[j];
                    } else if (s2.charAt(j) == target.charAt(i + j)){
                        result[j] = result[j + 1];
                    } else {
                        result[j] = false;
                    }
                }
            }
        }
        return result[0];
    }

}
