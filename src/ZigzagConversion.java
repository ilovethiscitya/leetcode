import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2/22/19.
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        boolean goDown = true;
        int curRow = 0;
        for(int i = 0; i < s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));
            if(curRow == 0 || curRow == numRows - 1) goDown = !goDown;
            curRow = goDown ? curRow + 1 : curRow - 1;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rows.size(); i++) {
            res.append(rows.get(i));
        }
        return res.toString();
    }
}
