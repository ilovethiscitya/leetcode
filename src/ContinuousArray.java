import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzhe on 10/25/18.
 */
public class ContinuousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> indexToSumMapping = new HashMap<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        indexToSumMapping.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (indexToSumMapping.containsKey(0-nums[i])) {
                max = Math.max(max, indexToSumMapping.get(-nums[i]));
            } else {
                indexToSumMapping.put(sum, i);
            }
        }
        return max;
    }
}
