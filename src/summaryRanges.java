import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 11/2/18.
 */
public class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;

        for(int i = 0; i < nums.length; i++) {
            // g corner case i = 0 就是本身
            if (i == 0) {

            } else {
                if (nums[i] == nums[i - 1] + 1) {
                    // do nothing
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (start != i) {
                        sb.append(nums[start]);
                        sb.append("->");
                        sb.append(nums[i - 1]);
                        start = i;
                        res.add(sb.toString());
                    } else {
                        sb.append(nums[i]);
                        res.add(sb.toString());
                    }

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (start != nums.length - 1) {
            sb.append(nums[start]);
            sb.append("->");
            sb.append(nums[nums.length - 1]);
            res.add(sb.toString());
        } else {
            sb.append(nums[nums.length - 1]);
            res.add(sb.toString());
        }
        return res;
    }
}
