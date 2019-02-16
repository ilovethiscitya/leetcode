import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by jianzhe on 1/27/19.
 */
public class sortByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            charToFreq.put(s.charAt(i), charToFreq.getOrDefault(s.charAt(i),0));

        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(charToFreq.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for(int j = 0; j < entry.getValue(); j++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
    private static void main(String[] args) {
        String a = "tree";
        sortByFrequency s = new sortByFrequency();
        System.out.println(s.frequencySort(a));
    }
}
