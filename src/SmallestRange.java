import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianzhe on 9/22/18.
 */
public class SmallestRange {
    public List<List<Integer>> smallestRangeI(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(a, 0, target, result, path);
        return result;
    }
    private void dfs(int[] a, int index, int target, List<List<Integer>> result, List<Integer> path) {
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(a[index] <= target) {
            path.add(a[index]);
            dfs(a, index, target - a[index], result, path);
            path.remove(path.size() - 1);
        }

        if(index + 1 < a.length) {
            dfs(a, index + 1, target, result, path);
        }
    }
    public static void main(String[] args) {
        int[] a = {3,2,6,7};
        SmallestRange r = new SmallestRange();
        List<List<Integer>> res = r.smallestRangeI(a, 7);
        for (List<Integer> list : res) {
            for(Integer i : list) {
                System.out.println(i);
            }
        }
    }
}
