import java.util.*;

/**
 * Created by jianzhe on 10/13/18.
 */
public class threeSumMulti {
    public int threeSumMulti(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) {
            c[a]++;
        }
        long res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && k == j) {
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                } else if (i == j && j != k) {
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                } else if (j < k) {
                    res += c[i] * c[j] * c[k];
                }
            }
        }
        return (int)(res % (1e9 + 7));
    }
//    public int threeSumMulti(int[] A, int target) {
//        List<List<Integer>> candidate = combinationSum2(A, target);
//        Map<Integer, Integer> map = new HashMap<>();
//        for (Integer num : A) {
//            if (map.containsKey(num)) {
//                int freq = map.get(num);
//                map.put(num, freq+1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        int result = 0;
//        for (List<Integer> candi : candidate) {
//            if (candi.size() == 3) {
//                int res = 1;
//                Map<Integer, Integer> map2 = new HashMap<>();
//                for (Integer ca : candi) {
//                    if (map2.containsKey(ca)) {
//                        map2.put(ca, map2.get(ca) + 1);
//                    } else {
//                        map2.put(ca,1);
//                    }
//                }
//                for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
//
//                    int value = entry.getValue();
//                    int key = entry.getKey();
//                    int freq = map.get(key);
////                    System.out.println(freq + ":");
////                    System.out.println(key + ",");
//                    System.out.println(combination(freq, value));
//                    res *= combination(freq, value);
//                }
//                System.out.println(res);
//                result += res;
//                System.out.println("...");
//            }
//
//        }
//        return result;
//    }
//    private static long factorial(int n) {
//        return (n > 1) ? n * factorial(n - 1) : 1;
//    }
//    public static long combination(int n, int m) {
//        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
//    }
//    public List<List<Integer>> combinationSum2(int[] nums, int target) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, target, 0);
//        return list;
//
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
//        if(remain < 0) return;
//        else if(remain == 0) list.add(new ArrayList<>(tempList));
//        else{
//            for(int i = start; i < nums.length; i++){
//                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums, remain - nums[i], i + 1);
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }
}
