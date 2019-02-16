import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianzhe on 1/25/19.
 */
public class nextClosestTime {
    public String nextClosestTime(String time) {
        String[] val = time.split(":");
        Set<Integer> set = new HashSet<>();
        int hour = Integer.parseInt(val[0]);
        int minute = Integer.parseInt(val[1]);
        set.add(hour / 10);
        set.add(hour % 10);

        set.add(minute / 10);
        set.add(minute % 10);

        int[] times = new int[] {hour, minute};
        nxt(times);
        while (!contains(times[0], times[1], set)) {
            nxt(times);
        }
        return valid(times[0]) + ":" + valid(times[1]);

    }
    public String valid(int time) {
        if(time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }
    public void nxt(int[] time) {
        int hour = time[0];
        int minu = time[1];
        minu++;
        if(minu == 60) {
            hour++;
            minu = 0;

            if(hour == 24) hour = 0;
        }
        time[0] = hour;
        time[1] = minu;
    }
    public boolean contains(int hour, int minu, Set<Integer> set) {
        return set.contains(hour / 10) && set.contains(hour % 10) &&
                set.contains(minu / 10) && set.contains(minu % 10);
    }
}
