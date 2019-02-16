import java.util.Arrays;

/**
 * Created by jianzhe on 10/7/18.
 */
public class threeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] < target) {
                    res+= r - l;
                    r--;
                } else
                    l++;
            }
        }
        return res;
    }
}
