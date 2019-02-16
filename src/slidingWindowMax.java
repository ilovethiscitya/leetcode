import java.util.TreeMap;

/**
 * Created by jianzhe on 10/15/18.
 */
public class slidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> valueToFreqBST = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (valueToFreqBST.containsKey(nums[i])) {
                valueToFreqBST.put(nums[i], valueToFreqBST.get(nums[i]) + 1);
            } else {
                valueToFreqBST.put(nums[i], 1);
            }
            if (i >= k) {
                valueToFreqBST.put(nums[i - k], valueToFreqBST.get(nums[i - k]) - 1);
                if (valueToFreqBST.get(nums[i - k]) == 0) {
                    valueToFreqBST.remove(nums[i - k]);
                }
            }
            if (i -k +1 >= 0) {
                res[i - k + 1] = valueToFreqBST.lastKey();
            }
        }
        return res;
    }
}
