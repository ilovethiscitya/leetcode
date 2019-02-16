/**
 * Created by jianzhe on 10/31/18.
 * Input : s = "bca"
 roll[] = {1, 2, 3}
 Output : eeb
 */
public class StringRoller {
    public String roll(String toRoll, int[] roll) {
        int toRollLength = toRoll.length();
        int[] rollCounts = new int[toRollLength];
        for(int i = 0; i < roll.length; i++) {
            rollCounts[roll[i] - 1]++;
        }
        for(int index = toRollLength - 2; index >= 0; index--) {
            rollCounts[index] += rollCounts[index + 1];
        }
        char[] toRollArray = toRoll.toCharArray();
        for (int i = 0; i < toRollLength; i++) {
            toRollArray[i] = (char)('a' + (rollCounts[i] % 26 + toRollArray[i] - 'a') %26);
        }
        return String.valueOf(toRollArray);
    }
}
