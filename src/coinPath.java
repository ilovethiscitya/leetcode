import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 12/3/18.
 */
public class coinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] minCosts = new int[A.length];
        int[] nextIndex = new int[A.length];

        int n = A.length;
        minCosts[n - 1] = A[n - 1];
        if(A[n - 1] == -1){
            return new ArrayList<>();
        }
        for(int i = n - 2; i >= 0; i--) {

            if(A[i] == -1) {
                nextIndex[i] = -1;
                continue;
            }
            minCosts[i] = Integer.MAX_VALUE;
            nextIndex[i] = -1;
            for(int next = i + 1; next <= Math.min(n - 1, i + B); next++) {
                if(nextIndex[next] != -1 && A[i] + minCosts[next] < minCosts[i]) {
                    minCosts[i] = A[i] + minCosts[next];
                    nextIndex[i] = next;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int cur = 0;
        if(nextIndex[0] == -1) {
            return res;
        }
        res.add(1);
        while(cur < n - 1) {
            res.add(nextIndex[cur] + 1);
            cur = nextIndex[cur];
        }
        return res;
    }
}
