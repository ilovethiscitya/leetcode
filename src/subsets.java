import java.util.Arrays;
import java.util.*;

/**
 * Created by jianzhe on 2018/2/23.
 */
public class subsets {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//        list.add(new ArrayList<>(tempList));
//        for(int i = start; i < nums.length; i++){
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, res, 0);
        return res;
    }
    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, int start) {
        if(start == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[start]);
        dfs(nums, path, res, start + 1);
        path.remove(path.size() - 1);
        dfs(nums, path, res, start + 1);
    }
}

