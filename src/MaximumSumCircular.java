import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

/**
 * Created by jianzhe on 10/6/18.
 */
public class MaximumSumCircular {
    public int maxSubarrySumCircular(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] B = new int[A.length * 2];
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i % A.length];
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = A.length - 1;
        int[] temp = new int[A.length];
        int[] maxEnd = new int[B.length];
        int[] maxSo = new int[B.length];
        while (start != A.length) {
            int tempS = start;
            int maxSoFar = A[start];
            int maxEnding = A[start];

            if (start == 0) {
                for (int i = 0; i < A.length; i++) {
                    maxEnding = Math.max(maxEnding + B[i], B[i]);
                    maxEnd[i] = maxEnding;
                    maxSoFar = Math.max(maxEnding, maxSoFar);
                    maxSo[i] = maxSoFar;
                }
            } else {
                maxEnding = Math.max(maxEnd[end - 1] + B[end], B[end]);
                maxEnd[end] = Math.max(maxEnd[end - 1]+ B[end], B[end]);
                maxSoFar = Math.max(maxEnding, maxSo[end - 1]);
                maxSo[end] = maxSoFar;
            }
            start++;
            end++;
        }
        for (int i = 0; i < B.length; i++) {
            max = Math.max(maxSo[i], max);
            System.out.println(maxSo[i]);
        }
        return max;
    }
    private int maxSubarray(int[] B) {
        int maxSoFar = B[0];
        int maxEnding = B[0];
        int[] maxSo = new int[B.length];
        int[] maxEnd = new int[B.length];
        for (int i = 1; i < B.length; i++) {
            maxEnding = Math.max(maxEnding + B[i], B[i]);
            maxEnd[i] = maxEnding;
            maxSoFar = Math.max(maxEnding, maxSoFar);
            maxSo[i] = maxSoFar;
        }
        return maxSoFar;
    }
}
