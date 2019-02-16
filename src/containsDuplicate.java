import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jianzhe on 10/16/18.
 */
public class containsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        TreeMap<Integer, Integer> valueToFreq = new TreeMap<>((o1, o2) -> {
            if (o1.equals(o2)) return 1;
            else
                return o1 - o2;
        });
        for (int i = 0; i < nums.length; i++) {
            if (valueToFreq.containsKey(nums[i])) {
                if (i - valueToFreq.get(nums[i]) <= k)
                    return true;
            }
            valueToFreq.put(nums[i], i);
        }
        return false;
    }
}
