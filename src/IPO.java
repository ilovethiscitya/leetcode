import java.util.PriorityQueue;

/**
 * Created by jianzhe on 1/25/19.
 */
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a1,a2) ->(a1[0] - a2[0]));
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a1,a2) -> (a2[0] - a1[0]));
//        int i = 0;
        for(int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[]{Profits[i], Capital[i]});
        }
        int j = 0;
        while(j < k) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }
            if (pqPro.isEmpty()) break;
            W += pqPro.poll()[1];
            j++;
        }
        return W;
    }
    public int findMax(int k, int W, int[] Profits, int[] Capital) {
        int maxProfit = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < Capital.length; j++) {
                if(Capital[j] <= W) {
                    pq.add(Profits[j]);
                }
            }
            W+= pq.poll();
        }
        return W;
    }

}
