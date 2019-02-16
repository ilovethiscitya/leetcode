/**
 * Created by jianzhe on 1/29/19.
 */
public class longPressedName {
    public boolean isPressed(String name, String typed) {
        int i = 0;
        int m = name.length();
        int j = 0;
        int n = typed.length();
        while (j < n) {
            if(i < m && name.charAt(i) == typed.charAt(j)) {
                i++;
            } else if(typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        return i == m;
    }

}

