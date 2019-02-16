import java.util.Arrays;

/**
 * Created by jianzhe on 10/31/18.
 */
public class numberOfPairs {
    public static int numberOfPairs(int[] a, long k) {
        if (a == null || a.length == 0) return 0;
        Arrays.sort(a);
        int start = 0;
        int end = a.length - 1;
        int res = 0;
        while (start < end) {
            if (start > 0 && a[start - 1] == a[start]) {
                start++;
                continue;
            }
            if (end < a.length && a[end - 1] == a[end]) {
                end--;
                continue;
            }
            if (a[start] + a[end] == k) {
                res ++;
                start++;
                end--;
            } else if (a[start] + a[end] < k) {
                start++;
                while (start < end && a[start] == a[start + 1]) start++;
            } else if (a[start] + a[end] > k) {
                end--;
                while (start < end && a[end] == a[end + 1]) end--;

            }
        }
        return res;
    }
}
