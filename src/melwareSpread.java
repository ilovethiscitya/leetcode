import java.util.*;

/**
 * Created by jianzhe on 2/2/19.
 */
public class melwareSpread {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        int n = graph.length;
        int m = graph[0].length;
        boolean[] visited = new boolean[n];
        Integer[] result = new Integer[n];
        int max = Integer.MIN_VALUE;
        int candidate = 0;
        for(int i = 0; i < initial.length; i++) {
            int res = dfs(graph, initial[i], visited, result);
            max = Math.max(res, max);
            if (res == max) {
                candidate = initial[i];
            }
        }
        return candidate;
    }
    private int dfs(int[][] graph, int start, boolean[] visited, Integer[]result) {
        if (visited[start]) return 0;
        if (result[start] != null) return result[start];
        visited[start] = true;
        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            if (start != i && graph[start][i] == 1) {
                res += dfs(graph, i, visited, result) + 1;
            }
        }
        result[start] = res;
        return res;
    }
    public static void main(String[] args) {
        int[][] graph = {{1, 0, 0}, {1, 1, 1}, {1, 1, 1}};
        melwareSpread m = new melwareSpread();
        int res = m.minMalwareSpread(graph, new int[]{1,2});
        System.out.println(res);
    }

//    class DSU {
//        int[] p;
//        int[] sz;
//        public DSU(int N) {
//            p = new int[N];
//            for (int i = 0; i < N; i++) {
//                p[i] = i;
//            }
//            sz = new int[N];
//            Arrays.fill(sz, 1);
//        }
//        public int find(int x) {
//            if (p[x] != x) {
//                p[x] = find(p[x]);
//            }
//            return p[x];
//        }
//        public void union(int x, int y) {
//            int xr = find(x);
//            int yr = find(y);
//            p[xr] = yr;
//            sz[yr] += sz[xr];
//        }
//        public int size(int x) {
//            return sz[x];
//        }
//
//    }
//    public int spread(int[][] matrix, int[] initial) {
//        int n = matrix.length;
//        DSU d = new DSU(n);
//        for(int i = 0; i < matrix.length; i++) {
//            for(int j = i + 1; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 1) {
//                    d.union(i, j);
//                }
//            }
//        }
//        int[] count = new int[n];
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for(int i = 0; i < initial.length; i++) {
//            int root = d.find(initial[i]);
//            int size = d.size(root);
//            if (!map.containsKey(size)) {
//                map.put(size, new ArrayList<>());
//            }
//            map.get(size).add(initial[i]);
//
//        }
//        int max = Integer.MIN_VALUE;
//        int id = -1;
//        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
//            if (entry.getKey() > max) {
//                max = Math.max(max, entry.getKey());
//                List<Integer> candidates = entry.getValue();
//                Collections.sort(candidates);
//                id = candidates.get(0);
//            }
//        }
//        return id;
//    }
//    public static void main(String[] args) {
//        int[][] graph = {{1,1,0}, {1,1,0}, {0,0,1}};
//        int[] initial = {0,1};
//        melwareSpread m = new melwareSpread();
//        System.out.println(m.spread(graph, initial));
//    }
//    public int spread(int[][] matrix, int[] initial) {
//        Set<Integer> sources = new HashSet<>();
//        for(int i = 0; i < matrix.length; i++) {
//            sources.add(i);
//        }
//        Boolean[] visited = new Boolean[matrix.length];
//        Arrays.sort(initial);
//        int maxConnected = 0;
//        int maxConnectedId = -1;
//        for(int i = 0; i < initial.length; i++) {
//            int start = initial[i];
//            Result neighbor = dfs(matrix, start, start, sources, visited);
//            if (neighbor.withOther && neighbor.connected > maxConnected)7吧 x {
//                maxConnected = neighbor.connected;
//                maxConnectedId = i;
//            }
//        }
//        return maxConnectedId == -1 ? initial[0] : maxConnectedId;
//    }
//    private Result dfs(int[][] matrix, int startId, int id, Set<Integer> sources, Boolean[] visited) {
//        if (visited[id]) return new Result(0, false);
//        visited[id] = true;
//        int connected = 1;
//        boolean withOther = id != startId && sources.contains(id);
//        for(int neighbor = 0; neighbor < matrix.length; neighbor++) {
//            if (matrix[id][neighbor] == 1) {
//                Result neighborRes = dfs(matrix, startI
// d, neighbor, sources, visited);
//                connected += neighborRes.conn吧        ected;
//                withOther |= neighborRes.withOther;
//            }
//        }
//        return new Result(connected, withOther);
//    }
//    public class Result {
//        int connected;
//        boolean withOther;
//        public Result(int connected, boolean withOther) {
//            connected = connected;
//            withOther = withOther;
//        }
//    }
}
