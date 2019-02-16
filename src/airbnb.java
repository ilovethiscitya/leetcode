import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by jianzhe on 10/10/18.
 */
public class airbnb {
    public int assignRooms1(List<int[]> list) {
        if (list == null || list.size() == 0) return 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>() ;
        for (int i = 0; i < list.size(); i++) {
            if (!treeMap.containsKey(list.get(i)[1])) {
                treeMap.put(list.get(i)[1], i);
            }
        }
        int[] dp = new int[list.size()];
        dp[0] = list.get(0)[1] - list.get(0)[0] + 1;
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] cur = list.get(i);
            int start = cur[0];
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(start);
            if (entry != null) {
                int index = entry.getValue();
                dp[i] = cur[1] - cur[0] + 1 + dp[index];
            } else {
                dp[i] = cur[1] - cur[0] + 1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max * 100;
    }
    public int assignroom2(List<int[]> list, int[] prices) {
        if (list == null || list.size() == 0) return 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>() ;
        for (int i = 0; i < list.size(); i++) {
            if (!treeMap.containsKey(list.get(i)[1])) {
                treeMap.put(list.get(i)[1], i);
            }
        }
        int[] dp = new int[list.size()];
        int initPrice = 0;
        for (int j = 0; j < list.get(0).length; j++) {
            initPrice += prices[list.get(0)[j]];
        }
        dp[0] = initPrice;
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] cur = list.get(i);
            int start = cur[0];
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(start);
            int curPrice = 0;
            for (int j = 0; j < cur.length; j++) {
                curPrice += prices[cur[j]];
            }
            if (entry != null) {
                int index = entry.getValue();
                dp[i] = dp[index] + curPrice;
            } else {
                dp[i] = curPrice;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;

    }

}
