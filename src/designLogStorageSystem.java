import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by jianzhe on 1/25/19.
 */
public class designLogStorageSystem {
    TreeMap<String, Integer> map;

    public designLogStorageSystem() {
        map = new TreeMap<>();
    }
    public void input(int id, String timestamp) {
        map.put(timestamp, id);
    }
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        if(s.compareTo(e) > 0) {
            return res;
        }
        int offset = getGra(gra);
        String start = s.substring(0, offset);
        String end = s.substring(0, offset);
        for(String time: map.subMap(start, end).keySet()){
            if(time.substring(0,offset).compareTo(end) > 0) {
                break;
            }
            res.add(map.get(time));
        }
        return res;

    }
    private int getGra(String s) {
        switch (s) {
            case "Year":
                return 4;
            case "Month":
                return 7;
            case "Day":
                return 10;
            case "Hour":
                return 13;
            case "Minute":
                return 16;
            case "Second":
                return 19;
            default:
                return 0;
        }
    }
}
