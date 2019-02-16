import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianzhe on 9/23/18.
 */
public class snakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] seen = new boolean[n * n];
        seen[0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int cur = queue.poll();
                for (int i = 1; i < 7; i++) {
                    int next = cur + i;
                    if (next > n * n) break;
                    int[] point = calculatePoint(next, n);
                    if (board[point[0]][point[1]] != -1) {
                        next = board[point[0]][point[1]] - 1;
                    }
                    if (next == n * n - 1) return step + 1;
                    if (!seen[next]) {
                        queue.offer(next);
                        seen[next] = true;
                    }
                }
            }
            step++;
        }
        return 0;
    }
    public int[] calculatePoint(int value, int n) {
        int row = (value - 1) / n;
        int curX = n - row - 1;
        int curY = row % 2 == 0 ? value - n * row - 1 : (row + 1) * n - value;
        return new int[]{curX, curY};
    }
}
//    int n;
//    public int snakesAndLadders(int[][] board) {
//        n = board.length;
//        boolean[] seen = new boolean[n*n];
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(0);
//        seen[0] = true;
//        int step = 0;
//        while(!q.isEmpty()){
//            int qsize = q.size();
//            while(qsize > 0){
//                int cur = q.poll();
//                for(int i = 1; i < 7; i++){
//                    int newc = cur+i;
//                    if(newc>=(n)*(n)) break;
//                    int[] po = decal(newc);
//                    if(board[po[0]][po[1]] != -1){
//                        newc = board[po[0]][po[1]]-1;
//                    }
//                    if(newc == n*n -1 ) return step+1;
//
//                    if(!seen[newc]){
//                        seen[newc] = true;
//                        q.offer(newc);
//                    }
//                }
//                qsize--;
//            }
//            step++;
//        }
//        return -1;
//    }
//    private int[] decal(int i){
//        int nx = i%n;
//        int ny = i/n;
//        if(ny%2==1){
//            nx = n-1-nx;
//        }
//        return new int[]{n-1-ny,nx};
//    }
//
//作者：西部小笼包
//        链接：https://www.jianshu.com/p/9dfa149953c2
//        來源：简书
//        简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
