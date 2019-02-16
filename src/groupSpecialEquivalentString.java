import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jianzhe on 10/10/18.
 */
public class groupSpecialEquivalentString {
    public int numSpecialEquivGrouops(String[] A) {
        if (A == null || A.length == 0) return 0;
        Map<String, Set<String>> wordToGroup = new HashMap<>();
        for (String word : A) {
            String str = getUniformed(word);
            if (!wordToGroup.containsKey(str)) {
                Set<String> set = new HashSet<>();
                set.add(word);
                wordToGroup.put(str, set);
            } else {
                Set<String> set = wordToGroup.get(str);
                set.add(word);
                wordToGroup.put(str, set);
            }
        }
        int res = 0;
        for (Map.Entry<String, Set<String>> entry : wordToGroup.entrySet()) {
            res++;
        }
        return res;
    }
    private String getUniformed(String word) {
        int i = 2;
        int j = 3;
        if (word.length() <= 2) return word;
        // odd
        char[] wordArray = word.toCharArray();
        while (i < word.length()) {
            if (word.charAt(i) < word.charAt(i - 2)) {
                swap(wordArray, i, i - 2);
            }
            i+=2;
        }
        if (word.length() >= 3) {
            while (j < word.length()) {
                if (word.charAt(j) < word.charAt(j - 2)) {
                    swap(wordArray, j, j - 2);
                }
                j+=2;
            }

        }
        return new String(wordArray);
    }
    private void swap(char[] wordArray, int i, int j) {
        char temp = wordArray[i];
        wordArray[i] = wordArray[j];
        wordArray[j] = temp;
    }
}
