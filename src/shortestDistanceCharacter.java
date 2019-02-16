/**
 * Created by jianzhe on 2/4/19.
 */
public class shortestDistanceCharacter {
//    public int[] shortest(String S, char C) {
//        int n = S.length();
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = S.charAt(i) == C ? 0: n;
//        }
//        for (int i = 1; i < n; i++) {
//            res[i] = Math.min(res[i], res[i - 1] + 1);
//        }
//
//        for (int i = n - 2; i >= 0; i--) {
//            res[i] = Math.min(res[i], res[i + 1] + 1);
//        }
//        return res;
//
//    }
    public int[] st(String S, char C) {
        int n = S.length();
        boolean[] visited = new boolean[n];
        return new int[n];
    }
}
