import java.util.*;

/**
 * Created by jianzhe on 10/26/18.
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //这样有重复的排列
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        HashSet<int[]> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[j - 1]) continue;
                int target = 0 - cur;
                if (valueToIndex.containsKey(target - nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    int[] candidate = new int[3];
                    candidate[0] = cur;
                    candidate[1] = nums[j];
                    candidate[2] = target - nums[j];
                    if (set.add(candidate)) {
                        res.add(list);
                    }
                } else {
                    valueToIndex.put(nums[j], j);
                }
            }

        }
        return res;
    }
}
