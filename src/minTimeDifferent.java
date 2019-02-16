import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jianzhe on 2/1/19.
 */
public class minTimeDifferent {
    public int minMin(List<String> timePoints) {
        int mm = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            String cur = timePoints.get(i);
            String[] timeStr = cur.split(":");
            int hh = Integer.parseInt(timeStr[0]);
            int min = Integer.parseInt(timeStr[1]);
            int allMin = 60 * hh + min;
            time.add(allMin);
        }
        Collections.sort(time);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < timePoints.size(); i++) {
            min = Math.min(time.get(i) - time.get(i - 1), min);
        }
        int corner = time.get(0) + (1440 - time.get(time.size() - 1));
        return Math.min(min, corner);
    }
    public static void main(String[] args) {
        String a = "23:59";
        String b = "23:10";
        String[] list = new String[2];
        list[0] = a;
        list[1] = b;
        minTimeDifferent m = new minTimeDifferent();
        int min = m.minMin(new ArrayList<>(Arrays.asList(list)));
        System.out.println(min);
    }
}
