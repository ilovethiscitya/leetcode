/**
 * Created by jianzhe on 9/8/18.
 */
public class numSubarrayProductLessThanK {
//    Input: nums = [10, 5, 2, 6], k = 100
//    Output: 8
//    Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
//    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
//    public int sum = 0;
//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return 0;
//        int product = nums[0];
//        dfsHelper(nums, k, 0, product);
//        return sum;
//    }
//    public void dfsHelper(int[] nums, int k, int start, int product) {
//        if (product >= k) return;
//        for (int i = start; i < nums.length; i++) {
//            product *= nums[i];
//            sum ++;
//            dfsHelper(nums, k, i + 1, product);
//            product /= nums[i];
//        }
//    }
    public int numSubarryProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 0;
        long p = 1l;
        int total = 0;
        while (j < nums.length) {
                p *= nums[j];
                while (i <= j && p >= k) {
                    i++;
                    p /= nums[i];
                }
                total += (j - i + 1);
        }
        return total;
    }
}
