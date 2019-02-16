/**
 * Created by jianzhe on 1/31/19.
 */
public class sentenceScreenFitting {
    public int wordsTyping(String[] sentences, int rows, int cols) {
//       String allStrs = String.join(" ", sentences) + " ";
//       int rowBegin = 0;
//       int rowEnd = 0;
//       int len = allStrs.length();
//       while (rows -- > 0) {
//           rowEnd = rowBegin + cols;
//           while (rowEnd > 0 && allStrs.charAt(rowEnd) != ' ') {
//               rowEnd--;
//           }
//           if (rowBegin > rowEnd) return 0;
//           rowBegin = rowEnd + 1;
//       }
//       return rowBegin / len;
//        int n = sentences.length;
//        int[] dp = new int[n];
//        for(int i = 0; i < sentences.length; i++) {
//            int length = 0;
//            int words = 0;
//            int index = i;
//            while (length + sentences[i % n].length() <= cols) {
//                words++;
//                index++;
//                length += sentences[i % n].length();
//                length += 1;
//            }
//            dp[i] = words;
//        }
//        int count = 0;
//        int words = 0;
//        for(int i = 0; i < rows; i++) {
//            words += dp[i];
//        }
//        return words / n;
//        int rowBegin = 0;
//        int rowEnd = 0;
//        String allStrs = String.join(" ", sentences) + " ";
//        int len = allStrs.length();
//        for(int i = rows; rows > 0; rows--) {
//            rowEnd = rowBegin + cols;
//            while(rowEnd > 0 && allStrs.charAt(rowEnd) != ' ') {
//                rowEnd--;
//            }
//            if(rowBegin > rowEnd) return -1;
//            rowBegin = rowEnd + 1;
//        }
//        return rowBegin / len;
        int len = sentences.length;
        int index = 0;
        int words = 0;
        int start = 0;
        int count = 0;
        for(int i = 0; i < rows; i++) {
            while (start + sentences[index].length() <= cols) {
                words++;
                start += sentences[index].length() + 1;
                index++;
                if (index == sentences.length) {
                    count++;
                    index = 0;
                }
            }
            start = 0;
        }
        return count;
    }
    public static void main(String[] args) {
        int rows = 3;
        int cols = 6;
        String[] strings = {"a", "bcd", "e"};
        sentenceScreenFitting s = new sentenceScreenFitting();
        int res = s.wordsTyping(strings, rows, cols);
        System.out.println(res);
    }
}
