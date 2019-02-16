/**
 * Created by jianzhe on 10/13/18.
 */
public class JewelsStones {
    public int numJewelsInStones(String J, String S) {
        int[] map = new int[256];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i)]++;
        }
        int cnt = 0;
        for (int j = 0; j < J.length(); j++) {
            cnt += map[J.charAt(j)];
        }
        return cnt;
    }
}
