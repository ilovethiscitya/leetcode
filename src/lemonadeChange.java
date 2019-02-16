/**
 * Created by jianzhe on 10/9/18.
 */
public class lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int res = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                res++;
            } else {
                int change = (bills[i] - 5) / 5;
                res -= change;
                if (res < 0) return false;
                res ++;

            }
        }
        return true;
    }
}
