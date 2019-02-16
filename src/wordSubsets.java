import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 9/29/18.
 */
public class wordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] map = new int[26];
        List<String> res = new ArrayList<>();
        for (String str : B) {
            int[] temp = processStr(str);
            for (int i = 0; i < map.length; i++) {
                map[i] = Math.max(temp[i], map[i]);
            }
        }
        for (String ori : A) {
            int[] temp = new int[26];
            for (int i = 0; i < ori.length(); i++) {
                temp[ori.charAt(i) - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < map.length; i++) {
                if (map[i] > temp[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(ori);
            }
        }
        return res;
    }
    private int[] processStr(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
}
