import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jianzhe on 10/22/18.
 */
public class rangeModule {
    private TreeMap<Integer, Integer> startToIndex = new TreeMap<>();
    public rangeModule(){

    }
    public void addRange(int left, int right) {
        removeRange(left, right);

        Integer floorKeyLeft = startToIndex.floorKey(left);
        if (floorKeyLeft != null && startToIndex.get(floorKeyLeft) == left) {
            startToIndex.put(floorKeyLeft, right);
        } else {
            startToIndex.put(left, right);
            floorKeyLeft = left;
        }
        if (startToIndex.containsKey(right)) {
            startToIndex.put(floorKeyLeft, startToIndex.get(right));
            startToIndex.remove(right);
        }

    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> floorLeft = startToIndex.floorEntry(left);
        return floorLeft != null && floorLeft.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        //很长的一个range
        Integer floorKey = startToIndex.floorKey(left);
        if (floorKey != null && startToIndex.get(floorKey) > right) {
            startToIndex.put(right, startToIndex.get(floorKey));
            startToIndex.put(floorKey, left);
            return;
        }


        // 一瓢range
        if (floorKey != null && startToIndex.get(floorKey) > left) {
            startToIndex.put(floorKey, left);
        }
        Integer floorKeyRight = startToIndex.floorKey(right);
        if (floorKeyRight != null && startToIndex.get(floorKeyRight) > right) {
            startToIndex.put(right, startToIndex.get(floorKeyRight));
        }
        startToIndex.subMap(left, right).clear();
    }

}
