import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 2018/5/22.
 */
public class interview2 {
    public static void string2(List<String> input, int begin, List<String> res) {
        if (begin == input.size()) {
            res.add("");
            return;
        }
        string2(input, begin + 1, res);
        int num = res.size();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < input.get(begin).length(); j++) {
                String str = input.get(begin).charAt(j) + res.get(i);
                res.add(str);
            }
        }
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("JAVA");
        input.add("CPP");
        input.add("PYTHON");
        input.add("GO");
        int sum = 0;
        List<String> res = new ArrayList<>();
        string2(input, 0, res);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).length() == 4) {
                System.out.println(res.get(i));
                sum++;
            }

        }
        System.out.println(sum);
    }

}
