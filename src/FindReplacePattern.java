import java.util.*;

/**
 * Created by jianzhe on 9/10/18.
 */
public class FindReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (Arrays.equals(F(w), p)) res.add(w);
        }
        return res;
    }
    public int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }
//    public List<String> findAndReplacePattern(String[] words, String pattern) {
//        if (words.length == 0 || words == null) return null;
//        StringBuilder sb = new StringBuilder();
//        int count = 1;
//        int i = 1;
//        while (i < pattern.length()) {
//            while (i < pattern.length() && pattern.charAt(i) == pattern.charAt(i - 1)) {
//                count++;
//                i++;
//            }
//            sb.append(count + ",");
//            count = 1;
//            i++;
//
//        }
//        String patternString = sb.toString();
//        List<String> list = new ArrayList<>();
//        Map<String, String> map = new HashMap<>();
//        count = 1;
//        for(int j = 0; j < words.length; j++) {
//            String cur = words[j];
//            StringBuilder stringBuilder = new StringBuilder();
//            int k = 1;
//            while (k < cur.length()) {
//                while (k < cur.length() && cur.charAt(k) == cur.charAt(k - 1)) {
//                    count++;
//                    k++;
//                }
//                stringBuilder.append(count + ",");
//                count = 1;
//                k++;
//            }
//            map.put(cur, stringBuilder.toString());
//        }
//
//        for (Map.Entry<String, String> entry: map.entrySet()) {
//            if (entry.getValue().equals(patternString)) {
//                list.add(entry.getKey());
//            }
//        }
//        return list;
//    }

}
