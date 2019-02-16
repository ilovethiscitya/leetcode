import java.util.*;

/**
 * Created by jianzhe on 1/27/19.
 */
public class EvaluateDivision {

//    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//        Map<String, List<Node>> map = new HashMap<>();
//        for(int i = 0; i < equations.length; i++) {
//            double val = values[i];
//            String point1 = equations[i][0];
//            String point2 = equations[i][1];
//            if(!map.containsKey(point1)) {
//                map.put(point1, new ArrayList<>());
//            }
//            if(!map.containsKey(point2)) {
//                map.put(point2, new ArrayList<>());
//            }
//            map.get(point1).add(new Node(point1, point2, val));
//            map.get(point2).add(new Node(point2, point1, 1/val));
//        }
//        double[] results = new double[queries.length];
//        for(int i = 0; i < queries.length; i++) {
//            String[] query = queries[i];
//            results[i] = dfs(map, query[0], query[1], new HashSet<>(), 1.0);
//
//            if(results[i] == 0.0) {
//                results[i] = -1.0;
//            }
//        }
//        return results;
//    }
//    private double dfs(Map<String, List<Node>> map, String start, String end, Set<String> set, double val) {
//        if(set.contains(start)) return 0.0;
//        if(!map.containsKey(start)) return 0.0;
//        if(start.equals(end)) return val;
//        set.add(start);
//        double temp = 0.0;
//        for(Node child : map.get(start)) {
//            temp = dfs(map, child.dest, end, set, val * child.val);
//            if(temp != 0.0) {
//                break;
//            }
//
//        }
//        set.remove(start);
//        return temp;
//    }
public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    // build graph
    Map<String, List<Node>> map = new HashMap<>();
    for(int i = 0; i < equations.length; i++) {
        String[] equation = equations[i];
        String start = equation[0];
        String end = equation[1];
        if(!map.containsKey(start)) {
            map.put(start, new ArrayList<>());

        }
        if(!map.containsKey(end)) {
            map.put(end, new ArrayList<>());
        }
        double val = values[i];
        map.get(start).add(new Node(start, end, val));
        map.get(end).add(new Node(end, start, 1 / val));
    }
    double[] result = new double[queries.length];
    for(int i = 0; i < queries.length; i++) {
        String[] query = queries[i];
        result[i] = dfs(map, query[0], query[1], new HashSet<String>(), 1.0);
        if (result[i] == 0.0) {
            result[i] = 1.0;
        }
    }
    return result;
}
private double dfs(Map<String, List<Node>> map, String start, String end, Set<String> set, double val) {
    if (!map.containsKey(start)) {
        return 0.0;
    }
    if(start.equals(end)) {
        return val;
    }
    if (set.contains(start)) {
        return 0.0;
    }
    set.add(start);
    double temp = 0.0;
    for(Node child : map.get(start)) {
        temp = dfs(map, child.dest, end, set, val * child.val);
        if (temp != 0.0) break;
    }
    return temp;
}
    class Node {
        String c;
        String dest;
        double val;
        public Node(String _c, String _dest, double _val) {
            c = _c;
            dest = _dest;
            val = _val;
        }
    }
    public static void main(String[] args) {
        String[][] equations  = {{"a","b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a","c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] results = new double[queries.length];
        results = new EvaluateDivision().calcEquation(equations, values, queries);
        for(double res : results) {
            System.out.println(res);
        }
    }
}
