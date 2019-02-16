import java.util.HashMap;
import java.util.List;

/**
 * Created by jianzhe on 10/30/18.
 */
public class keyboard_wish {
    public int keyboard(String s, String keypad) {
        if (s == null || s.length() == 0 || keypad == null || keypad.length() == 0) {
            return 0;
        }
        HashMap<List<Character>, Integer> charsToScore = new HashMap<>();
        char[][] keyboard = new char[3][3];
        for (int i = 0; i < keypad.length(); i++) {
            int row = i / keyboard.length;
            int col = i % keyboard[0].length;
            keyboard[row][col] = keypad.charAt(i);
        }
        return 0;
    }
}
