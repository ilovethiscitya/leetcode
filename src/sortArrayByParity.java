/**
 * Created by jianzhe on 10/9/18.
 */
public class sortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (start <= end) {
                if (A[i] % 2 == 0) {
                    swap(A, i, start++);
                } else {
                    swap(A, i, end--);
                }
            }

        }
        return A;
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
