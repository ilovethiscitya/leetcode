import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jianzhe on 2/1/19.
 */
public class findKPairsSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
//        for(int i = 0; i < nums1.length; i++) {
//            for(int j = 0; j < nums2.length; j++) {
//                int n1 = nums1[i];
//                int n2 = nums2[j];
//                q.offer(new int[]{n1, n2});
//            }
//        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < nums2.length && i < k; i++) {
            q.offer(new int[]{nums1[i],nums2[0], 0});
        }
        while (k-- > 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) continue;
            q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
//        for(int i = 0; i < k; i++) {
//            res.add(q.poll());
//        }
//        return res;

    }
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        List<int[]> res = new ArrayList<>();
        findKPairsSmallestSums f = new findKPairsSmallestSums();
        res = f.kSmallestPairs(nums1, nums2, 3);
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i)[0]);
            System.out.println(res.get(i)[1]);
        }
    }
}
