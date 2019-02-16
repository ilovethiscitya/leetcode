import java.util.Stack;

/**
 * Created by jianzhe on 10/6/18.
 */
public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length == 0) return 0;
//        int col = matrix[0].length;
//        int row = matrix.length;
//        int[] h = new int[col + 1];
//        h[col] = 0;
//        int max = 0;
//        for (int i = 0; i < row; i++) {
//            Stack<Integer> stack = new Stack<>();
//            for (int j = 0; j <= col; j++) {
//                if (j < row) {
//                    if (matrix[i][j] == 1) {
//                        h[i] += 1;
//                    } else {
//                        h[i] = 0;
//                    }
//                }
//                if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
//                    stack.push(i);
//                } else {
//                    while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
//                        int height = h[stack.pop()];
//                        int start = stack.isEmpty() ? -1 : stack.peek();
//                        int area = height * (i - start - 1);
//                        max = Math.max(area, max);
//                    }
//                    stack.push(i);
//                }
//            }
//        }
//        return max;
        if(matrix == null || matrix.length == 0) return 0;
        int col = matrix[0].length;
        int row = matrix.length;
        int [] h = new int[col + 1];
        int res = 0;
        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= col; j++) {
                if (j <col) {
                    if (matrix[i][j] == '1') {
                        h[j] += 1;
                    } else {
                        h[j] = 0;
                    }
                }
                if (stack.isEmpty() || h[j] >= h[stack.peek()] ) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && h[j] < h[stack.peek()]) {
                        int index = stack.pop();
                        int area = h[index] * (stack.isEmpty() ? j : ( j - 1 - stack.peek()));
                        res = Math.max(res,area);
                    }
                    stack.push(j);
                }
            }
        }
        return res;
    }
}
