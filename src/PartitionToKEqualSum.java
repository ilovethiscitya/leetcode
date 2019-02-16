import java.util.Arrays;

/**
 * Created by jianzhe on 1/16/19.
 */
public class PartitionToKEqualSum {
    public boolean canPartitonKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) {
            return false;
        }
        while (row > 0 && nums[row] == target) {
            row--;
            k--;
        }
        return dfs(nums, new int[k], target, row);

    }
    private boolean dfs(int[] nums, int[] group, int target, int row) {
        if (row < 0) return true;
        int cur = nums[row];
        for(int i = 0; i < group.length; i++) {
            if (group[i] + cur <= target) {
                group[i] += cur;
                if(dfs(nums, group, target, --row)){
                    return true;
                }
                group[i] -= cur;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        PartitionToKEqualSum  p = new PartitionToKEqualSum();
        int[] nums = {2,2,2,2,3,4,5};
        int k = 4;
        System.out.println(p.canPartitonKSubsets(nums, k));
    }
}
