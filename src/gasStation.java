/**
 * Created by jianzhe on 9/27/18.
 */
public class gasStation {
    public int canComplete(int[] gas, int[] cost) {
//        int totalSum = 0;
//        for (int i = 0; i < gas.length; i++) {
//            totalSum += gas[i] - cost[i];
//        }
//        if (totalSum < 0) return -1;
//        int start = 0;
//        int remaining = 0;
//        for (int i = 0; i < gas.length; i++) {
//            int cur = gas[i] - cost[i];
//            if (remaining < 0) {
//                remaining = 0;
//                start = i + 1;
//            } else {
//                remaining += cur;
//            }
//        }
//        return start;
        int[] fuel = new int[gas.length];
        int start = 0;
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            fuel[i] = gas[i] - cost[i];
            totalSum+= fuel[i];
            if (totalSum < 0) {
                start = i + 1;
                totalSum = 0;
                if (start == gas.length) return -1;
            }
        }
        int res = start;
        totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            if (start + i == gas.length) {
                start = -i;
            }
            totalSum += fuel[start + i];
            if (totalSum < 0) return -1;
        }
        return res;
    }
}
