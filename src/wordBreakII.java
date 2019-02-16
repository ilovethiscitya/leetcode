import java.util.LinkedList;
import java.util.List;

/**
 * Created by jianzhe on 11/30/18.
 */
public class wordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        final int n = s.length();
        for(int i = 0; i < n; i++) {
            dp[i] = new LinkedList<>();
        }
        dp[n - 1].add("");
        for(int i = n - 2; i >= 0; i--) {
            LinkedList<String> list = new LinkedList<>();
            char cur = s.charAt(i);
            for(int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (dp[j].size() > 0 && wordDict.contains(s.substring(i, j + 1))) {
                    System.out.println("execute this");
                    for (String l : dp[j]) {
                        list.add(0, l + s.substring(i, j + 1));
                    }
                }
            }
            dp[i] = list;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i].size());
        }
        return dp[0];
    }
}
