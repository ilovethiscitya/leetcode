import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianzhe on 10/12/18.
 * Input: "eceba"
 Output: 3
 Explanation: t is "ece" which its length is 3.
 */
public class LongestSubstringTwoDistinct {
    public int lengthOfLongestTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] map = new int[128];
        int cnt = 0;
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            char cur = s.charAt(j);
            map[cur]++;
            if (map[cur] == 1) cnt++;
            if (cnt > 2) {
                while (cnt > 2) {
                    char left = s.charAt(i);
                    map[left]--;
                    if (map[left] == 0) cnt--;
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
//        if (s == null || s.length() == 0) return 0;
//        HashMap<Character, Integer> charToIndex = new HashMap<>();
//        int max = 0;
//        int i = 0;
//        int j = 0;
//        while (j < s.length())
//         {
//            if (charToIndex.size() <= 2 ) {
//                charToIndex.put(s.charAt(j), j);
//                j++;
//            }
//            if (charToIndex.size() > 2) {
//                int leftMostIdx = findLeftMostIndex(charToIndex);
//                charToIndex.remove(s.charAt(leftMostIdx));
//                i = leftMostIdx + 1;
//            }
//            max = Math.max(max, j - i);
//        }
//        return max;
//    }
//    private int findLeftMostIndex(HashMap<Character, Integer> map) {
//        int min = Integer.MAX_VALUE;
//        for (Integer idx : map.values()) {
//            min = Math.min(min, idx);
//        }
//        return min;
//    }
}
