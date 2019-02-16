/**
 * Created by jianzhe on 1/30/19.
 */
public class beautifulArrangement {
    int count = 0;
    public int totalArrangement(int N) {
        int[] used = new int[N + 1];
        dfs(N, used, 0);
        return count;
    }
    private void dfs(int N, int[] used, int pos) {
        if(pos == N + 1) {
            count++;
            return;
        } else {
            for(int i = 1; i <= N; i++) {
                if(used[i] == 0 && ((i % pos) == 0) || (pos % i == 0) ) {
                    used[i] = 1;
                    dfs(N, used, pos + 1);
                    used[i] = 0;
                }
            }
        }
    }
}
