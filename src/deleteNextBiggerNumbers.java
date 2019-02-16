import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 11/1/18.
 */
public class deleteNextBiggerNumbers {
    // 5,8,10,3,4,2
    // result 5,3,2
    public int[] deleteNextBigger(int[] nums){
        int start = 0;
        int end = 0;
        List<Integer> list = new ArrayList<>();
        while (end < nums.length) {
            if (nums[start] >= nums[end]) {
                list.add(nums[end]);
                start = end;
            }
            end++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
