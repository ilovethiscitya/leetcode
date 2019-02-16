import java.util.*;

/**
 * Created by jianzhe on 2/15/19.
 */
public class mostCommon {
    public String mostCommon(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            map.put(words[i], map.getOrDefault(map.get(words[i]), 0) + 1);
            System.out.println(map.get(words[i]));
        }
        List<String> banList = new ArrayList<String>(Arrays.asList(banned));
        int max = Integer.MIN_VALUE;
        String res = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            if(banList.contains(entry.getKey())) {
                continue;
            }
            max = Math.max(max, entry.getValue());
        }
        System.out.println(max);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == (max)) {
                res = entry.getKey();
//            max = Math.max(max, entry.getValue());
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        mostCommon m = new mostCommon();
        String res = m.mostCommon(para, banned);
        System.out.println(res);
    }
}
