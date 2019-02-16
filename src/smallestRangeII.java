import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jianzhe on 9/22/18.
 * 只能取-K,+K。2种情况。
 我就用了暴力解法。把原数组 直接映射成新数组。
 新数组包含了原数组每一位VAL-K,和VAL+K
 下面我们就需要一个窗口，使得这个窗口包含原数组所有的INDEX。
 所以我们在构建新数组的时候，我们既要存它新的值，还要存它的原下标。
 然后找出所有的窗口取最小值即可。

 作者：西部小笼包
 链接：https://www.jianshu.com/p/9dfa149953c2
 來源：简书
 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public class smallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        int l = A.length;
        List<int[]> list = new ArrayList<>();
        int idx = 0;
        for (int i : A) {
            list.add(new int[]{i - K, idx});
            list.add(new int[]{i + K, idx++});
        }
        Collections.sort(list, (m, n) -> {return m[0] - n[0];});
        int[] map = new int[l];
        int i = 0;
        int j = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        l = list.size();
        while (i < l) {
            if (cnt != l / 2) {
                if (map[list.get(i++)[1]]++ == 0) {
                    cnt++;
                }
            } else {
                min = Math.min(min, list.get(i - 1)[0] - list.get(j)[0]);
                if (--map[list.get(j++)[0]] == 0) cnt--;
            }
        }
        return min;
//    public int max;
//    public int smallestRangeII(int[] A, int K) {
//        if (A == null || A.length == 0) return 0;
//        if (A.length == 1) return 0;
//        Arrays.sort(A);
//        List<List<Integer>> sets = new ArrayList<>();
//        for (int i = 0; i < A.length; i++) {
//            List<Integer> points = new ArrayList<>();
//            points.add(A[i] - K);
//            points.add(A[i] + K);
//            sets.add(new ArrayList<>(points));
//        }
//        helper(0, new ArrayList<>(), sets);
//        return max;
//    }
//    public void helper(int start, List<Integer> pair, List<List<Integer>> sets) {
//        if (start == sets.size()) return;
//        int curX = sets.get(start).get(0);
//        int curY = sets.get(start).get(1);
//


    }
}
