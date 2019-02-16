/**
 * Created by jianzhe on 2/1/19.
 */
public class minimumCostTickets {
    public int costTickets(int[] days, int[] costs) {
        boolean[] marked = new boolean[days[days.length - 1] + 1];
        for(int i = 0; i < days.length; i++) {
            marked[days[i]] = true;
        }
        int min = Integer.MAX_VALUE;
        int[] dp = new int[marked.length];
        for(int i = 1; i < marked.length; i++) {
            if (!marked[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            min = costs[0] + dp[i - 1];
            min = Math.min(min, costs[1] + dp[Math.max(0, i - 7)]);
            min = Math.min(min, costs[2] + dp[Math.max(0, i - 15)]);
            dp[i] = min;
        }
        return dp[marked.length - 1];

    }
    public static void main(String[] args) {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        minimumCostTickets m = new minimumCostTickets();
        System.out.println(m.costTickets(days, costs));
    }
}
