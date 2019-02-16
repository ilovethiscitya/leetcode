import java.util.*;

/**
 * Created by jianzhe on 10/10/18.
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> anagramToWord = new HashMap<>();
        for (String cur : strs) {
            char[] chars = cur.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!anagramToWord.containsKey(keyStr)) {
                anagramToWord.put(keyStr, new ArrayList<>());
            }
            anagramToWord.get(keyStr).add(cur);
        }
        return new ArrayList<>(anagramToWord.values());
    }
}
