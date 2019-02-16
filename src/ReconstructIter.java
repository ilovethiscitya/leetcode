import java.util.*;

/**
 * Created by jianzhe on 9/7/18.
 */
public class ReconstructIter {
//    private HashMap<String, List<String>> adjList = new HashMap<>();
//    private LinkedList<String> route = new LinkedList<>();
//    private int numTickets = 0;
//    private int numTicketsUsed = 0;
//
//    public List<String> findItinerary(String[][] tickets) {
//        if (tickets == null || tickets.length == 0) return route;
//        // build graph
//        numTickets = tickets.length;
//        for (int i = 0; i < tickets.length; ++i) {
//            if (!adjList.containsKey(tickets[i][0])) {
//                // create a new list
//                List<String> list = new ArrayList<>();
//                list.add(tickets[i][1]);
//                adjList.put(tickets[i][0], list);
//            } else {
//                // add to existing list
//                adjList.get(tickets[i][0]).add(tickets[i][1]);
//            }
//        }
//        // sort vertices in the adjacency list so they appear in lexical order
//        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
//            Collections.sort(entry.getValue());
//        }
//
//        // start DFS
//        route.add("JFK");
//        dfsRoute("JFK");
//        return route;
//    }
//
//    private void dfsRoute(String v) {
//        // base case: vertex v is not in adjacency list
//        // v is not a starting point in any itinerary, or we would have stored it
//        // thus we have reached end point in our DFS
//        if (!adjList.containsKey(v)) return;
//        List<String> list = adjList.get(v);
//        for (int i = 0; i < list.size(); ++i) {
//            String neighbor = list.get(i);
//            // remove ticket(route) from graph
//            list.remove(i);
//            route.add(neighbor);
//            numTicketsUsed++;
//            dfsRoute(neighbor);
//            // we only return when we have used all tickets
//            if (numTickets == numTicketsUsed) return;
//            // otherwise we need to revert the changes and try other tickets
//            list.add(i, neighbor);
//            // This line took me a long time to debug
//            // we must remove the last airport, since in an itinerary, the same airport can appear many times!!
//            route.removeLast();
//            numTicketsUsed--;
//        }
//    }
//      [[JFK, KUL], [JFK, NRT], [NRT, JFK]]
    private Map<String, List<String>> map = new HashMap<>();
    private int numTickets = 0;
    private int numTicketsUsed = 0;
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) return null;
        numTickets = tickets.length;
        List<String> res = new ArrayList<>();
        for(String[] airports : tickets) {
            if (!map.containsKey(airports[0])) {
                List<String> list = new ArrayList<>();
                list.add(airports[1]);
                map.put(airports[0], list);
            } else {
                map.get(airports[0]).add(airports[1]);
            }
        }
        // iterate the whole map and sort
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        res.add("JFK");
        dfs(map, res, "JFK");
        return res;
    }
    private void dfs(Map<String, List<String>> map, List<String> res, String word) {
        if (!map.containsKey(word)) return;
        List<String> candidate = map.get(word);
        for(int i = 0; i < candidate.size(); i++) {
            String next = candidate.get(i);
            candidate.remove(i);
            res.add(next);
            numTicketsUsed++;
            dfs(map, res, next);
            if (numTicketsUsed == numTickets) return;
            candidate.add(i, next);
            res.remove(res.size() - 1);
            numTicketsUsed--;

        }

    }
}
//    List<String> res = new ArrayList<>();
//    Map<String, List<String>> map = new HashMap<>();
//    public List<String> findIter(String[][] tickets) {
//        for (String[] airports : tickets) {
//            if (!map.containsKey(airports[0])) {
//                map.put(airports[0], new ArrayList<>());
//            }
//            map.get(airports[0]).add(airports[1]);
//        }
//        // 对key 定影的list 进行排序操作
//        for(String str: map.keySet()) {
//            Collections.sort(map.get(str));
//        }
//        helper("JFK");
//        return res;
//
//    }
//    private void helper(String start) {
//        if (!map.containsKey(start) || map.get(start).size() == 0) {
//            res.add(0, start);
//            return;
//        }
//        while (map.get(start).size() > 0) {
//            String to = map.get(start).remove(0);
//            helper(to);
//        }
//        res.add(0, start);
//    }
//    public static List<String> findIter(String[][] tickets) {
//        List<String> res = new ArrayList<>();
//        if(tickets == null || tickets.length == 0) return null;
//        String init = "JFK";
//        res.add("JFK");
//        helper(res, init, tickets, 0);
//        return res;
//    }
//    // how to check there is no duplicate
//    private static void helper(List<String> res, String start, String[][] tickets, int index) {
//        if (index == tickets.length) return;
//        List<String[]> helper = new ArrayList<>();
//        for(int i = 0; i < tickets.length; i++) {
//            String[] candidate = tickets[i];
//            if(candidate[0].equals(start)) {
//                helper.add(candidate);
//            }
//        }
//        if (helper.size() == 1) {
//            res.add(helper.get(0)[1]);
//            helper(res, helper.get(0)[1], tickets, ++index);
//        } else if (helper.size() > 1){
//            String next = checkList(helper); //要用map
//            res.add(next);
//            helper(res, next, tickets, ++index);
//        }
//    }
//    private static String checkList(List<String[]> helper) {
//        List<String> collect = new ArrayList<>();
//        for(int i = 0; i < helper.size(); i++) {
//            collect.add(helper.get(i)[0]);
//        }
//        Collections.sort(collect);
//        return collect.get(0);
//    }

