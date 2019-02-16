import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jianzhe on 2/1/19.
 */
public class shortestDistance {
    private Map<String, ArrayList<Integer>> map;
    public int findShortest(List<String> words, String word1, String word2) {
        for(int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if(!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
        int i = 0;
        int j = 0;
        int dist = Integer.MAX_VALUE;
        while(i < map.get(word1).size() && j < map.get(word2).size()) {
            dist = Math.min(dist, Math.abs(map.get(word1).get(i) - map.get(word2).get(j)));
            if(map.get(word1).get(i) < map.get(word2).get(j)) {
                i++;
            } else {
                j++;
            }

        }
        return dist;
    }
}
