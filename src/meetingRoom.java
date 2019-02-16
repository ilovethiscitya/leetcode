import java.util.Arrays;
import java.util.Collections;

/**
 * Created by jianzhe on 10/31/18.
 */
public class meetingRoom {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1.start ,o2.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start > intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}
