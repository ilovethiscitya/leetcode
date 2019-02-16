import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by jianzhe on 10/16/18.
 */
public class fallingSquare {
    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer, Interval> startToIntervals = new TreeMap<>();
        // 现在想的是把<start, height> 和 <end, height> 都存放进去， 然后找
        // 找其中的ceilingEntry
        int maxHeight = 0;
        List<Integer> res = new ArrayList<>();
        for(int[] position : positions) {
            int start = position[0];
            int end = start + position[1];
            int height = position[1];
            // delete?
            int preMaxHeight = 0;
            for (int coveredStart : startToIntervals.subMap(start, end).keySet()) {
                preMaxHeight = Math.max(preMaxHeight, startToIntervals.get(coveredStart)._height);
            }
            Integer leftKey = startToIntervals.lowerKey(start);
            if (leftKey != null) {
                Interval leftInterval = startToIntervals.get(leftKey);
                // overlapped
                if (leftInterval._end > start) {
                    preMaxHeight = Math.max(preMaxHeight, leftInterval._height);
                    if (leftInterval._end > end) {
                        startToIntervals.put(end, new Interval(leftInterval._end, leftInterval._height));
                    }
                    startToIntervals.put(leftKey, new Interval(start, leftInterval._height));
                }
            }
            Integer right = startToIntervals.lowerKey(end);
            if (right != null) {
                Interval rightInterval = startToIntervals.get(right);
                if (rightInterval._end > end) {
                    startToIntervals.put(end, new Interval(rightInterval._end, rightInterval._height));
                }
            }
            startToIntervals.subMap(start, end).clear();
            startToIntervals.put(start, new Interval(end, preMaxHeight + height));
            maxHeight = Math.max(maxHeight, preMaxHeight + height);
            res.add(maxHeight);
        }
          return res;
    }
    class Interval{
        int _end;
        int _height;
        public Interval(int end, int height){
            this._end = end;
            this._height = height;
        }
    }
}
