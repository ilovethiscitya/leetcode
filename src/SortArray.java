import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 10/13/18.
 */
public class SortArray {
    public int[] sortArray(int[] A) {
        if (A == null || A.length == 0) return A;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even.add(A[i]);
            } else odd.add(A[i]);
        }
        int[] res= new int[A.length];
        int evenIdx = 0;
        int oddIdx = 0;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) res[i] = even.get(evenIdx++);
            else {res[i] = odd.get(oddIdx++);}
        }
        return res;
    }
}
