import java.util.Arrays;

/**
 * Created by jianzhe on 10/31/18.
 */
public class MinimumNumberArrowsBurstBallons {
    public int findMinArrowsShots(int[][] points) {
        if (points == null || points[0].length == 0 || points.length == 0)
            return 0;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int res = 1;
        int arrowLimit = points[0][1];
        for(int i = 1; i < points.length; i++) {
            int[] baloon = points[i];
            if (baloon[0] <= arrowLimit) {
                arrowLimit = Math.min(arrowLimit, baloon[1]);
            } else {
                res++;
                arrowLimit = baloon[1];
            }
        }
        return res;
    }
}
