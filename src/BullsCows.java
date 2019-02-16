/**
 * Created by jianzhe on 10/11/18.
 */
public class BullsCows {
    public String getHing(String secret, String guess) {
        int[] A = new int[10];
        int[] B = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            A[secret.charAt(i) - '0']++;
        }
        int sizeA = 0;
        int sizeB = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                sizeA++;
                A[secret.charAt(i) - '0']--;
            } else if (A[guess.charAt(i) - '0'] != 0) {
                sizeB++;
                A[guess.charAt(i) - '0']--;
            }
        }
        return String.valueOf(sizeA) + "A" + String.valueOf(sizeB) + "B";
    }
}
