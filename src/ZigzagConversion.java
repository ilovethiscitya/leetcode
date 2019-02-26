import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2/22/19.
 */
public class ZigzagConversion {
    public void nextPermutation(int[] nums) {



    }
    private void swaps(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
