/**
 * Created by jianzhe on 9/29/18.
 */
public class partitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        if (A == null || A.length == 0) return 0;
        int maxSoFar = A[0];
        int max = maxSoFar;
        int len = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < max) {
                len = i;
                max = maxSoFar;
            }
            if (maxSoFar < A[i]) {
                maxSoFar = A[i];
            }
        }
        return len + 1;
    }
}
