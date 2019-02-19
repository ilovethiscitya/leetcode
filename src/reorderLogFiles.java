import java.util.Arrays;

/**
 * Created by jianzhe on 2/18/19.
 */
public class reorderLogFiles {
    public String[] reorder(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] s1 = log1.split(" ", 2);
            String[] s2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = s1[1].compareTo(s2[1]);
                if (cmp != 0) return cmp;
                return s1[0].compareTo(s2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
//    public String[] reorder(String[] logs) {
//        Arrays.sort(logs, (l1, l2) -> {
//            String[] s1 = l1.split(" ", 2);
//            String[] s2 = l2.split(" ", 2);
//            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
//            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
//            if (!isDigit1 && !isDigit2) {
//                int cmp = s1[1].compareTo(s2[1]);
//                if (cmp != 0) return cmp;
//                return s1[0].compareTo(s2[0]);
//            }
//            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
//        });
//    }
}
