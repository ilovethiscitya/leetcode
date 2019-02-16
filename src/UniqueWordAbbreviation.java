import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianzhe on 10/10/18.
 */
public class UniqueWordAbbreviation {
    HashMap<String, Set<String>> wordToAbbr;
    public UniqueWordAbbreviation(String[] dictionary) {
        wordToAbbr = new HashMap<>();
        for(String word : dictionary) {
            String key = getAbbr(word);
            if (!wordToAbbr.containsKey(key)) {
                Set<String> set = new HashSet<>();
                set.add(word);
                wordToAbbr.put(key, set);
            } else {
                Set<String> oldSet = wordToAbbr.get(key);
                oldSet.add(word);
                wordToAbbr.put(key, oldSet);
            }
        }
    }
    private String getAbbr(String key) {
        if (key.length() <= 2) return key;
        String abbr = key.charAt(0) + "" + String.valueOf(key.length() - 2) + key.charAt(key.length() - 1);
        return abbr;
    }
    public boolean isUnique(String word) {
        String key = getAbbr(word);
        Set<String> set = wordToAbbr.get(key);

        if (set == null) {
            return true;
        } else if (set.size() == 1) {
            if (set.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
