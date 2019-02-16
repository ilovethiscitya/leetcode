/**
 * Created by jianzhe on 9/16/18.
 */
public class fruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int[] map = new int[40001];
        int max = 0;
        int cnt = 0;
        int l = 0, r = 0;
        while (r < tree.length) {
            if (map[tree[r++]]++ == 0) {
                cnt++;
            }
            while (cnt > 2) {
                if (--map[tree[l]] == 0) {
                    cnt--;
                }
                l++;

            }
            max = Math.max(max, r - l);
        }
        return max;
    }
}
