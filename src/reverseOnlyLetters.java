import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianzhe on 10/6/18.
 */
public class reverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        Map<Integer, Character> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        int end = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
                list.add(chars[i]);
            } else {
                map.put(i, chars[i]);
            }

        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(i) != null) {
                chars[i] = map.get(i);
            } else {
                chars[i] = list.remove(list.size() - 1);
            }
        }
        return new String(chars);
    }
    private void reverse(char[] chars, int start, int end) {
        char temp = '1';
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

    }
}
