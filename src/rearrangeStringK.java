import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jianzhe on 2/3/19.
 */
public class rearrangeStringK {
    public String rearrange(String s, int k) {
        if(k <= 0) return s;
        int[] charToFreq = new int[26];
        PriorityQueue<Integer> maxFreq = new PriorityQueue<>(((o1, o2) -> charToFreq[o1] ==
        charToFreq[o2] ? Integer.compare(o1, o2) : Integer.compare(charToFreq[o1], charToFreq[o2])
        ));
        for(int i = 0; i < s.length(); i++) {
            charToFreq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < charToFreq.length; i++) {
            if (charToFreq[i] > 0) {
                maxFreq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!maxFreq.isEmpty()) {
            List<Integer> polled = new ArrayList<>();
            int size = Math.min(maxFreq.size(), k);
            for (int i = 0; i < size; i++) {
                int curChar = maxFreq.poll();
                sb.append((char)(curChar + 'a'));
                charToFreq[curChar]--;
                polled.add(curChar);
                if (charToFreq[curChar] > 0) {
                    maxFreq.add(curChar);
                }
            }
            if (size > k && !polled.isEmpty()) {
                return "";
            }

        }
        return sb.toString();
    }
}
