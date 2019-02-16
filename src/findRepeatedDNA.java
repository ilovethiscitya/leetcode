import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianzhe on 10/13/18.
 */
public class findRepeatedDNA {
    public List<String> findRepeatedDNASequence(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (s == null || s.length() <= 10) return res;
        Set<String> resset = new HashSet<>();
        int len = s.length();
        for (int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!set.add(sub)) {
                resset.add(sub);
            }
        }
        res.addAll(resset);
        return res;
    }
}
