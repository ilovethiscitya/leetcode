import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianzhe on 11/1/18.
 */
public class boldWords {
    public String boldWords(String[] words, String S) {
        // 对words里面按照首字母的先后进行排序，进行merge
        // 如果merge之后的字符串存在于S当中，就记录下来，舍弃之前的两个区间
        Arrays.sort(words);
        StringBuilder sb = new StringBuilder();
//        if (words.length == 1) {
//            int index = S.indexOf(words[0]);
//            sb.append(words[0].toCharArray());
//        }
        List<String> candidates = new ArrayList<>();
        //字符merge
        for (int i = 1; i < words.length; i++) {
            if (i == 1) {
                String cur = words[1];
                String pre = words[0];
                int index = 0;
                while (index < cur.length() && cur.charAt(index) <= pre.charAt(pre.length() - 1)) {
                    index++;
                }
                String newString = pre + cur.substring(index, pre.length());
                if (S.contains(newString)) {
                    candidates.add(newString);
                }
            } else {
                String cur = words[i];
                String pre = candidates.size() == 0 ? words[i - 1] : candidates.get(candidates.size() - 1);
                int index = 0;
                while (index < cur.length() && cur.charAt(index) <= pre.charAt(pre.length() - 1)) {
                    index++;
                }
                String newString = pre + cur.substring(index, cur.length());

                if (S.contains(newString)) {
                    candidates.remove(candidates.size() - 1);
                    candidates.add(newString);
                } else {
                    candidates.add(cur);
                }
            }
        }
//        for (int j = 0; j < candidates.size(); j++) {
//            System.out.println(candidates.get(j));
//        }
        StringBuilder newsb  = new StringBuilder();
        int i = 0;
        while (i < S.length() && candidates.size() > 0) {
            String candidate = candidates.get(0);
            if (i + candidate.length() <= S.length() && S.substring(i, i + candidate.length()).equals(candidate)) {

                sb.append("<b>");
                sb.append(candidates.get(0));
                sb.append("</b>");
                i += candidate.length();
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
