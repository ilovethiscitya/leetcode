import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzhe on 10/25/18.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToIndexMapping = new HashMap<>();
        int sum = 0;
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j < sum) {
                j *= k;
                if (sumToIndexMapping.containsKey(sum - j)) {
                    return true;
                }
            }
            sumToIndexMapping.put(sum, i);

        }
        return false;
    }
}
