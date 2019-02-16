import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzhe on 11/14/18.
 */
public class twoPointDirection {
    public String twoPointDirection(int[] p1, int[] p2) {
        StringBuilder sb = new StringBuilder();
        if (p2[0] - p1[0] > 0) {
            sb.append("N");
        } else if (p2[0] - p1[0] < 0){
            sb.append("S");
        }
        if(p2[1] - p1[1] > 0) {
            sb.append("E");
        } else if (p2[1] - p1[1] < 0) {
            sb.append("W");
        }
        return sb.toString();
    }
}
