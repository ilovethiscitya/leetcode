import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianzhe on 9/12/18.
 */
public class FractionAdditionAndSubstraction {
    public String fractionAddition(String expression) {
        if (expression == null || expression.length() == 0)
            return "";
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (j <= expression.length()) {
            if (j == expression.length() || (i != j) && (expression.charAt(j) =='+' || expression.charAt(j) == '-') ) {
                if (expression.charAt(i) == '+') {
                    list.add(expression.substring(i + 1, j));
                } else {
                    list.add(expression.substring(i, j));
                }
                i = j;
            }
            j++;
        }
        String res = "0/1";
        for (String str : list) {
//            System.out.println(str);
            res = addNum(res, str);
        }
        return res;
    }
    public String addNum(String res, String str) {
        String[] s1 = res.split("/");
        String[] s2 = str.split("/");
        int n1 = Integer.parseInt(s1[0]);
        int d1 = Integer.parseInt(s1[1]);
        int n2 = Integer.parseInt(s2[0]);
        int d2 = Integer.parseInt(s2[1]);

        int n = n1 * d2 - n2 * d1;
        int d = d1 * d2;
        boolean isNegative = n * d < 0;
        n = Math.abs(n);
        d = Math.abs(d);
        System.out.println("N:" + n);
        System.out.println("D:" + d);
        if (n == 0) return "0/1";
        int gcdN = getGCD(n,d);

        System.out.println("GCD : " + gcdN);
        return (isNegative ? "-" : "") + (n / gcdN) + "/" + (d / gcdN);
    }
//    public String fractionAddition(String expression) {
//        List<String> list = new ArrayList<>();
//        int i = 0, j = 0;
//        while (j <= expression.length()) {
//            if (j == expression.length() || i != j && ((expression.charAt(j) == '+') || expression.charAt(j) == '-')) {
//                if (expression.charAt(i) == '+') {
//                    list.add(expression.substring(i + 1, j));
//                } else {
//                    list.add(expression.substring(i, j));
//                }
//                i = j;
//            }
//            j++;
//        }
//        String result = "0/1";
//        for (String num : list) {
//            result = add(result, num);
//        }
//        return result;
//    }
//    public String add(String s1, String s2) {
//        String[] sa1 = s1.split("/");
//        String[] sa2 = s2.split("/");
//        int n1 = Integer.parseInt(sa1[0]);
//        int d1 = Integer.parseInt(sa1[1]);
//        int n2 = Integer.parseInt(sa2[0]);
//        int d2 = Integer.parseInt(sa2[1]);
//        int n = n1 * d2 + n2 * d1;
//        int d = d1 * d2;
//        if (n == 0) return "0/1";
//
//        boolean isNegative = n * d < 0;
//        n = Math.abs(n);
//        d = Math.abs(d);
//        int gcd = getGCD(n,d);
//        return (isNegative ? "-" : "") + (n / gcd) + "/" + (d / gcd);
//
//    }
    public int getGCD(int a, int b) {
        if (a == 0 || b == 0) return a + b;
        return getGCD(b, a % b);
    }
//    public String fractionAddition(String expression) {
//        if (expression.charAt(0) != '-') {
//            expression = "+" + expression;
//        }
//        List<Character> sign = new ArrayList<>();
//        List<Integer> den = new ArrayList<>();
//        List<Integer> numer = new ArrayList<>();
//        for (int i = 0; i < expression.length(); i++) {
//            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
//                sign.add(expression.charAt(i));
//            }
//        }
//        for (String sub : expression.split("(\\+) |(-)")) {
//            if (sub.length() > 0) {
//                String[] fraction = sub.split("/");
//                numer.add(Integer.parseInt(fraction[0]));
//                den.add(Integer.parseInt(fraction[1]));
//            }
//        }
//        int numi = 0;
//        int deni = 1;
//        for (int n : den) {
//            deni *= n;
//        }
//        for (int i = 0; i < numer.size(); i++) {
//            int top = numer.get(i);
//            int d = deni / den.get(i);
//            if (sign.get(i) == '+') {
//                numi += top * d;
//            } else {
//                numi = numi - top * d;
//            }
//        }
//        int gcd = getGCD(Math.abs(numi), Math.abs(deni));
//        return (numi / gcd) + "/" + (deni / gcd);
//    }
//    public String fractionAddi(String expression) {
//        if (expression == null || expression.length() == 0 ) return "";
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        int j = 0;
//        while (j <= expression.length()) {
//            if (j == expression.length() || (i < j) && (expression.charAt(i) == '+' || expression.charAt(i) == '-') ) {
//                if (expression.charAt(i) == '+') {
//                    list.add(expression.substring(i, j));
//                } else
//                    list.add(expression.substring(i, j + 1));
//                i = j;
//            }
//            j++;
//        }
//        String res = "0/1";
//        for (String num : list) {
//            res = addNum(res, num);
//        }
//        return res;
//    }
//    private String addNum(String res, String num) {
//        int n1 = Integer.parseInt(res.split("/")[0]);
//        int d1 = Integer.parseInt(res.split("/")[1]);
//        int n2 = Integer.parseInt(num.split("/")[0]);
//        int d2 = Integer.parseInt(num.split("/")[1]);
//        int n = n1 * d2 - n2 * d1;
//        int d = d1 * d2;
//        boolean isNegative = n * d < 0;
//        n = Math.abs(n);
//        d = Math.abs(d);
//        if (n == 0) return "0/1";
//        int gcdN = getGCD(n,d);
//        return isNegative ? "-" + (n / gcdN) : "" +  (n / gcdN);
//
//    }

}
