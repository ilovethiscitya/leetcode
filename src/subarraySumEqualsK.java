import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianzhe on 9/26/18.
 */
public class subarraySumEqualsK {
    public int subarray(int[] nums, int k) {
//        int[] sums = new int[nums.length + 1];
//        for (int i = 1; i <= nums.length; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                System.out.println(sums[j + 1] - sums[i]);
//            }
//        }
//        return -1;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//        int sum = 0;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            if (map.containsKey(sum - k)) {
//                count+= map.get(sum - k);
//            }
//            map.put(sum, map.getOrDefault(sum, 0) + 1);
//        }
//        return count;
        int sum = nums[0];
        int res = sum;
        for (int i = 1; i < nums.length; i++) {
            sum += (i + 1) * nums[i];
            res += sum;
        }
        return res;
    }
}
