import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by jianzhe on 9/26/18.
 */
public class courseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {return a[1] - b[1];});
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int time = 0;
        for (int[]course : courses) {
            time+=course[0];
            pq.add(course[0]);
            if (time > course[1]) time -= pq.poll();
        }
        return pq.size();
    }
}
