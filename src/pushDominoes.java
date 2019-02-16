/**
 * Created by jianzhe on 2/4/19.
 */
public class pushDominoes {
    public String pushDominoe(String d) {
        d = "L" + d + "R";
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 1; j < d.length(); j++) {
            if (d.charAt(j) == '.') continue;
            int middle = j - i - 1;
            if (i > 0) res.append(d.charAt(i));
            if (d.charAt(i) == d.charAt(j)) {
                for (int k = 0; k < middle; k++) {
                    res.append(d.charAt(i));
                }
            } else if (d.charAt(i) == 'L' && d.charAt(j) == 'R') {
                for (int k = 0; k < middle; k++) {
                    res.append('.');
                }
            } else {
                for (int k = 0; k < middle / 2; k++) {
                    res.append('R');
                }
                if (middle % 2 == 1) res.append('.');
                for (int k = 0; k < middle / 2; k++) {
                    res.append('L');
                }
            }
            i = j;

        }
        return res.toString();

    }
    public static void main(String[] args) {
        String a = ".L.R...LR..L..";
        pushDominoes p = new pushDominoes();

        String res = p.pushDominoe(a);
        System.out.println(res);
    }
}
