/**
 * Created by jianzhe on 2/4/19.
 */
public class maximumProductWordLength {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] bytes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words.length; j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }
        for (int i = 0; i < bytes.length; i++) {
            for (int j = i + 1; j < bytes.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
