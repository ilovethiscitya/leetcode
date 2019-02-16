/**
 * Created by jianzhe on 2/4/19.
 */
public class largestSumAverages {
    public void largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][][] dp = new double[n][n][K];
        int[] preSum = new int[n];
        for (int cur : A) {

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < K; k++) {
                    for (int t = j - 1; t >= i; t--) {
                        dp[i][j][k] = 1;
                    }
                }
            }
        }
    }
}
