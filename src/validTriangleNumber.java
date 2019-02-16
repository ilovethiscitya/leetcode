import java.util.Arrays;

/**
 * Created by jianzhe on 10/7/18.
 */
public class validTriangleNumber {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[k] + nums[j] > nums[i]) {
                        res++;
                    } else break;
                }
            }
        }
        return res;
    }
}
