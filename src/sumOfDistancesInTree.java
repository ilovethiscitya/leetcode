import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by jianzhe on 1/31/19.
 */
public class sumOfDistancesInTree {
//    int[] res, count;
//    ArrayList<HashSet<Integer>> tree;
//    int n;
//    public int[] sumOfDistance(int N, int[][] edges) {
//        tree = new ArrayList<>();
//        res = new int[N];
//        count = new int[N];
//        n = N;
//        for(int i = 0; i < N; i++) {
//            tree.add(new HashSet<>());
//        }
//        for(int[] e : edges) {
//            tree.get(e[0]).add(e[1]);
//            tree.get(e[1]).add(e[0]);
//        }
//        dfs(0, new HashSet<Integer>());
//        dfs2(0, new HashSet<Integer>());
//        return res;
//    }
//    public void dfs(int root, HashSet<Integer> seen) {
//        seen.add(root);
//        for(int i : tree.get(root)) {
//            if(!seen.contains(i)) {
//                dfs(i, seen);
//                count[root] += count[i];
//                res[root] += res[i] + count[i];
//            }
//        }
//        count[root]++;
//    }
//
//    public void dfs2(int root, HashSet<Integer> seen) {
//        seen.add(root);
//        for(int i : tree.get(root)) {
//            if(!seen.contains(i)) {
//                res[i] = res[root] - count[i] + n - count[i];
//                dfs(i, seen);
//            }
//        }
//    }
    int[] res;
    int[] count;
    int n;
    ArrayList<HashSet<Integer>> tree;
    public int[] sumOfDistance(int N, int[][] edges) {
        tree = new ArrayList<>();
        n = N;
        res = new int[N];
        count = new int[N];
        for(int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }
        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            tree.get(start).add(end);
            tree.get(end).add(start);
        }
        dfs(0);
        dfs1(0);
        return res;
    }
    private void dfs(int start) {
        for(int child : tree.get(start)) {
            dfs(child);
            count[start] += count[child];
            res[start] += res[child] + count[child];
        }
        count[start]++;
    }
    private void dfs1(int start) {
        for(int child : tree.get(start)) {
            res[child] = res[start] - count[child] + n - count[child];
            dfs(child);
        }
    }
}
