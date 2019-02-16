/**
 * Created by jianzhe on 11/30/18.
 */
public class houseRobberii {
    public int rob(int[] nums) {
        // dag
        Integer[] results = new Integer[nums.length + 1];
//        System.out.println(dfs(nums, 0, results, true));
        System.out.println(dfs(nums, 1, results, false));
        return Math.max(dfs(nums, 0, results, true), dfs(nums, 1, results, false));
    }
    private int dfs(int[] nums, int index, Integer[] results, boolean isFirst) {
        if(index >= nums.length) {
            return 0;
        }
        if(results[index] != null) {
            return results[index];
        }
        int max = 0;
        for(int i = index + 2; i < nums.length; i+=2) {
            if(isFirst && i == nums.length - 1){
                continue;
            } else{
                max = Math.max(dfs(nums, i, results, isFirst), max);
            }

        }
        results[index] = nums[index] + max;
        return results[index];
    }
}
