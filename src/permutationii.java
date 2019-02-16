import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jianzhe on 1/12/19.
 */
public class permutationii {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute(nums, 0, used, path, res);
        return res;
    }
    private void permute(int[] nums, int startIndex, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (startIndex == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int childIndex = startIndex; childIndex < nums.length; childIndex++) {
            if ((childIndex > 0 && nums[childIndex - 1] == nums[childIndex] && !used[childIndex - 1])){
                continue;
            } else {
                used[startIndex] = true;
                swap(nums, startIndex, childIndex);
                path.add(nums[startIndex]);
                permute(nums, startIndex + 1, used, path, res);
                path.remove(path.size() - 1);
                swap(nums, startIndex, childIndex);
                used[startIndex] = false;
            }
            }
        }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    public static void main(String[] args) {
        permutationii i = new permutationii();
        int[] nums = {1,0,0};
        List<List<Integer>> res = i.permuteUnique(nums);
        for (List<Integer> list : res) {
            for (Integer j : list) {
                System.out.println(j);
            }
            System.out.println("...");
        }
        char[][] candidates1 = new char[][] {{'1','1'}, {'6','9'}, {'9','6'}, {'8','8'}};
        System.out.println(candidates1[0]);
    }
}
