import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jianzhe on 2/17/19.
 */
public class moviesInFlight {
    public int[] longestMovie(int[] dur, int d) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int target = d - 30;
        int max = Integer.MIN_VALUE;
        int[] candidate = new int[2];
        for(int i = 0; i < dur.length; i++) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(target - dur[i]);
            if (entry != null) {
                max = Math.max(max, entry.getKey() + dur[i]);
                if (entry.getKey() + dur[i] == max) {
                    candidate[0] = i;
                    candidate[1] = entry.getValue();
                }
            }
            map.put(dur[i], i);
        }
        return candidate;
    }
    public static void main(String[] args) {
        int[] dur = new int[]{1, 2, 3, 4, 5, 6};
        int target = 139;
        moviesInFlight m = new moviesInFlight();
        int[] res = m.longestMovie(dur, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
