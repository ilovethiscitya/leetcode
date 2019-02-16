import java.util.*;

/**
 * Created by jianzhe on 9/25/18.
 */
public class busStop {
    public int numBusedToDestination(int[][] routes, int S, int T) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        if (S == T) return 0;
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                List<Integer> bus = map.getOrDefault(routes[i][j], new ArrayList<>());
                bus.add(i);
                map.put(routes[i][j], bus);
            }
        }
        q.offer(S);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int cur = q.poll();
                List<Integer> candidates = map.get(cur);
                for (int candidate : candidates) {
                    if(visited.contains(candidate)) continue;
                    visited.add(candidate);
                    for (int k = 0; k < routes[candidate].length; k++) {
                        if (routes[candidate][k] == T) return res + 1;
                        q.offer(routes[candidate][k]);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public int numStops(int[][] routes, int S, int T) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < routes.length; i++) {
            int[] cur = routes[i];
            for (int j = 0; j < cur.length; j++) {
                List<Integer> lines = map.getOrDefault(cur[j], new ArrayList<>());
                lines.add(i);
                map.put(cur[i], lines);
            }
        }
        int res = 0;
        q.offer(S);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int bus = q.poll();
                List<Integer> candidate = map.get(bus);
                for (int candi : candidate) {
                    if (visited.contains(candi)) continue;
                    visited.add(candi);
                    for (int k = 0; k < routes[candi].length; k++) {
                        if (routes[candi][k] == T) return res + 1;
                        q.offer(routes[candi][k]);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
