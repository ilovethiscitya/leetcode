/**
 * Created by jianzhe on 10/4/18.
 */
public class maximumSubarray {
//    O(n ^ 2)解法
//    public int maxSequence(int[] arr) {
//        int len = arr.length;
//        int max = arr[0];
//        for (int i = 0; i < len; i++) {
//            int sum = 0;
//            for (int j = i; j < len; j++) {
//                sum += arr[j];
//                if (sum > max) max = sum;
//            }
//        }
//        return max;
//    }
    // O(n) 解法
//    public int maxsequence(int[] arr) {
//        int maxsum, maxhere;
//        maxsum = maxhere = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (maxhere < 0) {
//                maxhere = arr[i];
//            } else {
//                maxhere += arr[i];
//            }
//            if (maxhere > maxsum) {
//                maxsum = maxhere;
//            }
//        }
//        return maxsum;
//    }
    public int maxMatrix(int[][] matrix) {
        int n = matrix.length;
        int[] curSum = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    // curSum[k] = max(curSum[k - 1] + matrix[j][k], matrix[j][k])
                    curSum[k] += matrix[j][k];
                    sum += curSum[k];
                    if (sum < 0) {
                        sum = curSum[k];
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}
