/**
 * Created by jianzhe on 11/1/18.
 */
public class reverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] str = s.split("\\s+");
        for(String stt : str) {
            System.out.println(stt);
            System.out.println("+++++++++");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(str[i]);
            } else {
                sb.append(str[i]).append(" ");
            }
        }
        System.out.println(sb.toString());
        return "";
    }
}
