import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzhe on 1/29/19.
 */
public class stickerToWord {
//    public int minTickets(String[] stickers, String target) {
//        int m = stickers.length;
//        int[][] mp = new int[m][26];
//        Map<String, Integer> map = new HashMap<>();
//        for(int i = 0; i < m; i++) {
//            for(char c : stickers[i].toCharArray()) {
//                mp[i][c - 'a']++;
//            }
//        }
//        map.put("", 0);
//        return helper(map, mp, target);
//    }
//    private int helper(Map<String, Integer> map, int[][] mp, String target) {
//        if(map.containsKey(target)) {
//            return map.get(target);
//        }
//        int ans = Integer.MAX_VALUE;
//        int n = mp.length;
//        int[] tar = new int[26];
//        for(char c : target.toCharArray()) {
//            tar[c - 'a']++;
//        }
//        for(int i = 0; i < n; i++) {
//            if(mp[i][target.charAt(0) - 'a'] == 0) continue;
//            StringBuilder sb = new StringBuilder();
//            for(int j = 0; j < 26; j++) {
//                if(tar[j] > 0) {
//                    for(int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
//                        sb.append((char)('a' + j));
//                    }
//                }
//            }
//            String s = sb.toString();
//            int tmp = helper(map, mp, s);
//            if (tmp != - 1) {
//                ans = Math.min(ans, 1 + tmp);
//            }
//        }
//        map.put(target, ans == Integer.MAX_VALUE ? - 1 : ans);
//        return map.get(target);
//    }
    public int minStickers(String[] stickers, String target) {
        Map<String, Integer> map = new HashMap<>();
        int n = stickers.length;
        int[][] mp = new int[n][26];
        for(int i = 0; i < stickers.length; i++) {
            for(char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }
        map.put("",0);
        return dfs(map, mp, target);
    }
    private int dfs(Map<String, Integer> map, int[][] mp, String target) {
        if(map.containsKey(target)) {
            return map.get(target);
        }
        int[] tar = new int[26];
        int ans = Integer.MAX_VALUE;
        int n = mp.length;
        for(char c : target.toCharArray()) {
            tar[c - 'a']++;
        }
        for(int i = 0; i < n; i++) {
            if(mp[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                if(tar[j] > 0) {

                    for(int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            String newTarget = sb.toString();
            int temp = dfs(map, mp, newTarget);
            if(temp != -1) {
                ans = Math.min(ans, temp + 1);
            }

        }
        map.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return map.get(target);
    }
}
