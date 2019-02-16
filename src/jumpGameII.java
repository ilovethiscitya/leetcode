import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by jianzhe on 2/4/19.
 */
public class jumpGameII {
    public int jump(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        map.put(0, 0);
        int n = nums.length;
        while(!queue.isEmpty()) {
            int index = queue.remove();
            for(int size = map.size(); size <= Math.min(n - 1, nums[index] + index); size++) {
                queue.add(size);
                map.put(size, map.get(index) + 1);
            }
        }
        return map.get(nums.length - 1);
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        jumpGameII j = new jumpGameII();
        int res = j.jump(nums);
        System.out.println(res);
    }
}
