import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianzhe on 10/9/18.
 */
public class MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurantToIndex = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            restaurantToIndex.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (restaurantToIndex.containsKey(list2[i])) {
                min = Math.min(min, i + restaurantToIndex.get(list2[i]));
                map.put(list2[i], restaurantToIndex.get(list2[i]) + i);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                res.add(entry.getKey());
            }
        }
        String[] ret = new String[res.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
