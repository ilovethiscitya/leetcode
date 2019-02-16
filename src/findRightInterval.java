import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jianzhe on 9/14/18.
 */
public class findRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> intervalToIndex = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            intervalToIndex.put(intervals[i].start, i);

        }
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervalToIndex.ceilingEntry(intervals[i].end) == null) {
                res[i] = -1;
            } else {
                res[i] = intervalToIndex.ceilingEntry(intervals[i].end).getValue();
            }
        }
        return res;
//        int[] start = new int[intervals.length];
//        int[] end = new int[intervals.length];
//        int[] res = new int[intervals.length];
//        for(int i = 0; i < intervals.length; i++) {
//            start[i] = intervals[i].start;
//            end[i] = intervals[i].end;
//        }
//
//        for (int i = 0; i < intervals.length; i++) {
//            int toTest = end[i];
//            int min = Integer.MAX_VALUE;
//            int toStore = -1;
//            for (int j = 0; j < intervals.length; j++) {
//                if(i == j) continue;
//                if (start[j] >= toTest) {
//                    min = Math.min(min, start[j]);
//                    toStore = min == start[j] ? j : toStore;
//                }
//            }
//            res[i] = toStore;
//        }
//        return res;
    }
//    public int[] findRightInterval(Interval[] intervals) {
//        int[] result = new int[intervals.length];
//        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
//
//        for (int i = 0; i < intervals.length; ++i) {
//            intervalMap.put(intervals[i].start, i);
//        }
//
//        for (int i = 0; i < intervals.length; ++i) {
//            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
//            result[i] = (entry != null) ? entry.getValue() : -1;
//        }
//
//        return result;
//    }
//public class Solution {
//    public int[] findRightInterval(Interval[] intervals) {
//        if(intervals == null){
//            return null;
//        }
//        Map<Interval, Integer> hp = new HashMap<>();
////storing indexes in hashmap since we wanna sort the array.
//        for(int i = 0; i < intervals.length; i++){
//            Interval n = intervals[i];
//            hp.put(n, i);
//        }
//
//        boolean f = false;
//        int[] ind = new int[intervals.length];
//        Arrays.sort(intervals, (a,b) -> a.start - b.start);
//        for(int i = 0; i < intervals.length; i++){
//            for(int j = i + 1; j <intervals.length; j++){//the starting point of every element before ith element is smaller than its ending point. So ignore them.
//                if(intervals[j].start >= intervals[i].end){
//                    ind[hp.get(intervals[i])]  = hp.get(intervals[j]) ;
//                    f = true;
//                    break;
//                }
//
//            }
//            if(!f){//if there is not such an interval
//                ind[hp.get(intervals[i])] = -1;
//
//            }
//            f = false;
//        }
//        return ind;
//    }
//}
}
