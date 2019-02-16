import java.util.*;

/**
 * Created by jianzhe on 10/17/18.
 */
public class reorganizeString {
    public String reorganizeString(String s, int k) {
        int[] charToFreq = new int[26];
        final int offset = 'a';
        PriorityQueue<Integer> maxFreq = new PriorityQueue<>((o1, o2) -> charToFreq[o1] == charToFreq[o2] ? Integer.compare(o1, o2) : Integer.compare(charToFreq[o2], charToFreq[o1]));
        //统计频率
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            charToFreq[cur - offset]++;
        }
        // 放入priorityQueue当中去
        for(int i = 0; i < charToFreq.length;i++) {
            if(charToFreq[i] > 0) {
                maxFreq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!maxFreq.isEmpty()) {
            int size = Math.min(k, maxFreq.size());
            System.out.print(size);
            List<Integer> polled = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                int curChar = maxFreq.poll();
                sb.append((char)(curChar + offset));
                charToFreq[curChar]--;
                if(charToFreq[curChar] > 0) {
                    polled.add(curChar);
                }
            }
            if(size < k && !polled.isEmpty()) {
                return "";
            }
            // 重新放回去
            for(int index : polled) {
                maxFreq.add(index);
            }
        }
        return sb.toString();
    }
//    public String reorganizeString(String S) {
//        Map<Character, Integer> charToFreq = new HashMap<>();
//        for (int i = 0; i < S.length(); i++) {
//            int count = charToFreq.getOrDefault(S.charAt(i), 0) + 1;
//            if (count > (S.length() + 1) / 2) return "";
//            charToFreq.put(S.charAt(i), count);
//        }
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//        for (char c : charToFreq.keySet()) {
//            pq.add(new int[] {c, charToFreq.get(c)});
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!pq.isEmpty()) {
//            int[] first = pq.poll();
//            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
//                sb.append((char) first[0]);
//                if (--first[1] > 0) {
//                    pq.add(first);
//                }
//            } else {
//                int[] second = pq.poll();
//                sb.append((char) second[0]);
//                if (--second[1] > 0) {
//                    pq.add(second);
//                }
//                pq.add(first);
//            }
//        }
//        return sb.toString();
//    }
}
