/**
 * Created by jianzhe on 2/7/19.
 */
public class arrayNesting {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            // go as far as possible
            int cur = nums[i];
            while (!visited[cur]) {
                count++;
                visited[cur] = true;
                cur = nums[cur];
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
