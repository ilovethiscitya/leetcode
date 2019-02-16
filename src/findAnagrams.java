import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 10/22/18.
 */
public class findAnagrams {
    public List<Integer> findAnagram(String s, String p) {
        final int size = 26;
        final int offset = 'a';
        List<Integer> result = new ArrayList<>();
        final int m = p.length();
        int[] charToFreqP = new int[size];
        for (int i = 0; i < p.length(); i++) {
            charToFreqP[p.charAt(i) - offset]++;
        }
        int dist = m;
        final int n = s.length();
        int[] charToFreqS = new int[size];
        for (int i = 0; i < n; i++) {
            charToFreqS[s.charAt(i) - offset]++;

            if (charToFreqP[s.charAt(i) - offset] > 0 && charToFreqS[s.charAt(i) - offset] <=
                   charToFreqP[s.charAt(i) - offset]
                    ) {
                dist--;
            }
            // remove s[i - m]
            if (i >= m) {
                charToFreqS[s.charAt(i - m) - offset]--;
                if (charToFreqP[s.charAt(i - m) - offset] > 0 && charToFreqS[s.charAt(i) - offset] <= charToFreqP[s.charAt(i) - offset]) {
                    dist++;
                }
            }
            if(dist == 0) {
                result.add(i - m + 1);
            }
        }
        return result;
    }
}
