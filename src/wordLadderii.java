import java.util.*;

/**
 * Created by jianzhe on 10/5/18.
 */
public class wordLadderii {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>>
                     nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }

            }
            if (foundEnd) break;
        }

    }
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }
        return res;
    }
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
                     HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution,res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
    // 因为是最短路径，所以dfs是不可以的！！
//    public void dfsHelper(String beginWord, String endWord, List<String> ladder, List<String>
//            wordList, HashSet<String> seen, List<List<String>>res) {
//        if (beginWord.equals(endWord)) {
//            res.add(new ArrayList<>(ladder));
//
//        }
//
//        for (int i = 0; i < beginWord.length(); i++) {
//            char[] curChar = beginWord.toCharArray();
//            for (char j = 'a'; j <= 'z'; j++) {
//                curChar[i] = j;
//                String transformed = new String(curChar);
//
//                if (!seen.contains(transformed) && wordList.contains(transformed)) {
//                    ladder.add(transformed);
//                    seen.add(transformed);
//                    dfsHelper(transformed, endWord, ladder, wordList, seen, res);
//                    ladder.remove(ladder.size() - 1);
////                    seen.remove(transformed);
//                }
//            }
//        }
//    }

}
