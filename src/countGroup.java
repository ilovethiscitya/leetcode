import java.util.Arrays;

/**
 * Created by jianzhe on 1/31/19.
 */
public class countGroup {
    public boolean canSatisfy(int[] nums, int n) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if(sum % n != 0) {
            return false;
        }
        int target = sum / n;
        int len = nums.length;
        if(nums[len - 1] > target) {
            return false;
        }
        int rows = len - 1;
        int i = 0;
        while (i < n && nums[rows] == target) {
            rows--;
            n--;
        }
        return dfs(nums, target, new int[n], rows);
    }
    private boolean dfs(int[] nums, int target, int[] group, int pos) {
        if(pos >= group.length) {
            return true;
        }
        for(int i = 0; i < group.length; i++) {
            if(group[i] + nums[pos] <= target) {
                group[i] += nums[pos];
                if(dfs(nums, target, group, pos + 1)){
                    return true;
                }
                group[i] -= nums[pos];
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        countGroup c = new countGroup();
        System.out.println(c.canSatisfy(nums, 4));
    }
}
