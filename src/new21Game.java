/**
 * Created by jianzhe on 2/1/19.
 */
public class new21Game {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + 1];
        double res = 0.0;
        int pSum = 1;
        for(int i = 1; i <= N; i++) {
            dp[i] = pSum / W;
            if(i < K) {
                pSum += dp[i];
            } else {
                res += dp[i];
            }
            if (i - W + 1 > 0) {
                pSum -= dp[i];
            }
        }
        return res;
    }
    public double new21(int N, int K, int W) {
        int[] dp = new int[N + 1];
        int pSum = 1;
        double res = 0.0;
        for(int i = 1; i <= N; i++) {
            dp[i] = pSum / W;
            if(i < K) {
                pSum += dp[i];
            } else {
                res += dp[i];
            }
            if (i - W + 1 > 0) {
                pSum -= dp[i];
            }
        }
        return res;
    }
}
