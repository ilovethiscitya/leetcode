import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianzhe on 9/28/18.
 */
public class partitionLabels {
    public boolean canPartitionh(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        int target = sum / k;
        if (nums[nums.length - 1] > target) return false;
        int n = nums.length - 1;
        while (n >= 0 && nums[n] == target) {
            n--;
            k--;
        }
        return dfs(nums, new int[k], n, target);
    }
    private boolean dfs(int[] nums, int[] group, int n, int target) {
        // choose group for every num
        if(n < 0) return true;
        int cur = nums[n];
        for(int i = 0; i < group.length; i++) {
            if(cur + group[i] <= target) {
                group[i] += cur;
                if(dfs(nums, group, n - 1, target)) {
                    return true;
                }
                group[i] -= cur;
            }
        }
        return false;
    }
}
