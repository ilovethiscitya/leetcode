/**
 * Created by jianzhe on 11/14/18.
 */
public class reverseNumberPalindrome {
    public int calculateReverse(int num) {
        int reversed = reverseNum(num);
        int sum = num + reversed;
        while (!palindrome(sum)) {
            reversed = reverseNum(sum);
            sum = reversed + sum;
        }
        return sum;
    }
    public int reverseNum(int num) {
        String input= String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }
    public boolean palindrome(int sum) {
        String toCompare = String.valueOf(sum);
        int i = 0;
        int j = toCompare.length() - 1;
        while (i < j) {
            if (toCompare.charAt(i) != toCompare.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
