/**
 * Created by jianzhe on 11/14/18.
 *
 *
 *
 *
 *
 */
public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] usedCoin = new int[amount + 1];
        for(int i = 0; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                usedCoin[i] = Integer.MAX_VALUE;
                if(i - coins[j] > 0) {
                    usedCoin[i] = Math.min(usedCoin[i - coins[j]] + 1, usedCoin[i]);
                }
            }
        }
        return usedCoin[amount] == Integer.MAX_VALUE ? -1 :usedCoin[amount];
    }
}
