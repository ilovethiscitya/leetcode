/**
 * Created by jianzhe on 1/31/19.
 */
public class maxSumCircular {
    public int maxCircular(int[] A) {
        int len = A.length * 2 - 1;
        int curMax = 0;
        int max = Integer.MIN_VALUE;
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < len; i++) {
            if(i < A.length) {
                if(A[i] + curMax > A[i]) {
                    curMax = A[i] + curMax;
                    p2 = i;
                } else {
                    curMax = A[i];
                    p1 = i;
                    p2 = i;
                }
                max = Math.max(max, curMax);
            } else {
                int idx = i - A.length;
                if(Math.abs(p1 - p2) == 0) {
                    break;
                }
                if(A[idx] + curMax > A[idx]) {
                    curMax = A[idx] + curMax;
                    p2 = idx;
                } else {
                    curMax = A[idx];
                    p1 = idx;
                    p2 = idx;
                }
                max = Math.max(max, curMax);
            }

        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        maxSumCircular s = new maxSumCircular();
        System.out.println(s.maxCircular(nums));
    }
}
