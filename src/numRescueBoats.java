import java.util.Arrays;

/**
 * Created by jianzhe on 11/2/18.
 */
public class numRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < people.length; i++) {
            int cur = people[i];
            if (sum > limit) {
                res += 1;
                sum = cur;
            }
            if (cur < limit) {
                sum += cur;
            } else {
                res += 1;
                sum = cur;
            }


        }
        if (people[people.length - 1] > limit) {
            res += 1;
        }
        return res;
    }
}
