import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzhe on 9/7/18.
 */
public class fractionToDecimal {
//    public String fractionToDeciaml(int numerator, int denominator) {
//        long num = (long) numerator;
//        long deno = (long) denominator;
//        if (num % deno == 0) return Long.toString(num / deno);
//        StringBuilder res = new StringBuilder();
//        res.append((numerator > 0) ^ (denominator > 0) ? "-" :"");
//        res.append(num / deno);
//        // fraction part
//        num %= deno;
//        res.append(".");
//        HashMap<Long, Integer> map = new HashMap<>();
//        map.put(num, res.length());
//        while (num != 0) {
//            num *= 10;
//            res.append(num / deno);
//            num %= deno;
//            if (map.containsKey(num)) {
//                int index = map.get(num);
//                res.insert(index, "(");
//                res.append(")");
//                break;
//            } else {
//                map.put(num, res.length());
//            }
//        }
//        return res.toString();
//    }

    public String fraction2(int numerator, int denos) {
        if (numerator == 0) return "0";
        long num = (long)Math.abs(numerator);
        long deno = (long)Math.abs(denos);
        StringBuilder sb = new StringBuilder();
        if (num % deno == 0) return Long.toString(num / deno);
        sb.append((numerator > 0) ^ (denos > 0) ? "-" :  "");
        // Integer part
        sb.append(num / deno);
        num %= deno;
        // decimal part
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / deno);
            num %= deno;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());

            }
        }
        return sb.toString();
    }
}
