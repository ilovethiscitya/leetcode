import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2/17/19.
 */
public class windowSizeKSubarray {
    public List<String> findWindowK(String letters, int k) {
        int i = 0;
        int j = 0;
        int size = 0;
        int[] map = new int[26];
        List<String> res = new ArrayList<>();
        while (j < letters.length()) {
            if (map[letters.charAt(j) - 'a'] == 0) {
                size++;
            }
            map[letters.charAt(j)- 'a']++;
            if (j >= k) {
                map[letters.charAt(i) - 'a'] --;
                if (map[letters.charAt(i) - 'a'] == 0) {
                    size--;
                }
                i++;
            }
            if (size == k) {

                res.add(letters.substring(i, j + 1));
            }
            j++;
        }
        return res;
    }
    public static void main(String[] args) {
        String input = "adfgkg";
        windowSizeKSubarray w = new windowSizeKSubarray();
        List<String> res = w.findWindowK(input, 4);
        for (String a : res) {
            System.out.println(a);
        }
    }
}
