import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jianzhe on 10/13/18.
 */
public class palindromePermutation {
    public boolean canPermutePalindrome(String s) {
//        if (s == null || s.length() <= 1) return true;
//        Map<Character,Integer> charToFreq = new HashMap<>();
//        for(int i = 0; i < s.length(); i++) {
//            if (!charToFreq.containsKey(s.charAt(i))) {
//                charToFreq.put(s.charAt(i), 1);
//            } else {
//                charToFreq.put(s.charAt(i), charToFreq.get(s.charAt(i)) + 1);
//            }
//        }
//        if (s.length() % 2 == 0) {
//            for (Integer freq : charToFreq.values()) {
//                if (freq % 2 != 0)
//                    return false;
//            }
//        } else {
//            int oddFreq = 0;
//            for (Integer freq : charToFreq.values()) {
//                if (freq % 2 != 0) {
//                    oddFreq++;
//                }
//            }
//            if (oddFreq >= 1) return false;
//        }
//        return true;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                set.remove(s.charAt(i));
            }
        }
        return set.size() == 0 || set.size() == 1;
    }
}
