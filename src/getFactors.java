import java.util.ArrayList;
import java.util.List;

////
//Numbers can be regarded as product of its factors. For example,
//
//        8 = 2 x 2 x 2;
//        = 2 x 4.
//        Write a function that takes an integer n and return all possible combinations of its factors.
//
//        Note:
//
//        Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
//        You may assume that n is always positive.
//        Factors should be greater than 1 and less than n.
public class getFactors {
    public List<List<Integer>> getFactor(int n) {
        if (n == 1) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(n, 2, new ArrayList<>(), res);
        return res;
    }
    private void helper(int n, int start, List<Integer> list, List<List<Integer>>res) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
        } else {
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    helper(n/i, i, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
