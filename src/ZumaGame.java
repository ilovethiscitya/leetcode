import java.util.*;

/**
 * Created by jianzhe on 1/29/19.
 */
public class ZumaGame {
//    public int findMinStep(String board, String hand) {
//        Map<Character, Integer> map = new HashMap<>();
//        List<Character> boardList = new ArrayList<>();
//        for(int i = 0; i < board.length(); i++) {
//            boardList.add(board.charAt(i));
//        }
//        map.put('R', 0);
//        map.put('Y', 0);
//        map.put('B', 0);
//        map.put('G', 0);
//        map.put('W', 0);
//        for (int i = 0; i < hand.length(); i++) {
//            map.put(hand.charAt(i), map.get(hand.charAt(i)) + 1);
//        }
//        return dfs(boardList, map);
//    }
//    private int dfs(List<Character> boardList, Map<Character, Integer> map) {
//        cleanup(boardList);
//        if (boardList.size() == 0) {
//            return 0;
//        }
//        if (isEmpty(map)) {
//            return -1;
//        }
//        int count = 0;
//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i < boardList.size(); i++) {
//           count++;
//           char cur = boardList.get(i);
//           if (i == boardList.size() - 1 || boardList.get(i) != boardList.get(i + 1)) {
//               int missing = 3 - count;
//               if(map.get(cur) >= missing) {
//                   map.put(cur, map.get(cur) - missing);
//                   List<Character> smallerBoard = new ArrayList<>();
//                   for (int j = 0; j < count; j++) {
//                       smallerBoard.remove(j);
//                   }
//                   int temp = dfs(smallerBoard, map);
//                   map.put(cur, map.get(cur) + missing);
//                   if (temp != -1) {
//                       min = Math.min(min, temp + missing);
//                   }
//               }
//           }
//           count = 0;
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }
//    public int findMinStep(String board, String hand) {
//        List<Character> boardList = new ArrayList<>();
//        for(char c : board.toCharArray()) {
//            boardList.add(c);
//        }
//        Map<Character, Integer> handMap = new HashMap<>();
//        handMap.put('R', 0);
//        handMap.put('Y', 0);
//        handMap.put('B', 0);
//        handMap.put('G', 0);
//        handMap.put('W', 0);
//        for(char c : hand.toCharArray()) {
//            handMap.put(c, handMap.get(c) + 1);
//        }
//        return findMin(boardList, handMap);
//    }
//    private int findMin(List<Character> boardList, Map<Character, Integer> handMap) {
//        cleanup(boardList);
//        if (boardList.size() == 0) {
//            return 0;
//        }
//        if (empty(handMap)) {
//            return -1;
//        }
//        int min = Integer.MAX_VALUE;
//        int count = 0;
//        for(int i = 0; i < boardList.size(); i++) {
//            char c = boardList.get(i);
//            count++;
//            if(i == boardList.size() - 1 || boardList.get(i) != boardList.get(i + 1)) {
//                int missing = 3 - count;
//                if (handMap.get(c) >= missing) {
//                    handMap.put(c, handMap.get(c) - missing);
//                    List<Character> smallerBoard = new ArrayList<>(boardList);
//                    for (int j = 0; j < count; j++) {
//                        smallerBoard.remove(i - j);
//                    }
//                    int smallerFind = findMin(smallerBoard, handMap);
//                    handMap.put(c, handMap.get(c) + missing);
//                    if (smallerFind != -1) {
//                        min = Math.min(min, smallerFind + missing);
//                    }
//
//                }
//                count = 0;
//            }
//        }
//        return min == Integer.MAX_VALUE ? - 1 : min;
//    }
//    private void cleanup(List<Character> board) {
//        int count = 0;
//        boolean isClean = false;
//        for(int i = 0; i < board.size(); i++) {
//            count++;
//            int j = i + 1;
//            while (j < board.size() && board.get(j) == board.get(i)) {
//                j++;
//                count++;
//            }
//            if (count >= 3) {
//                for(j = 0; j < count; j++) {
//                    board.remove(i);
//                }
//                isClean = true;
//                break;
//            }
//            count = 0;
//        }
//        if (isClean) {
//            cleanup(board);
//        }
//    }
//    private boolean empty(Map<Character, Integer> hand) {
//        for (int val : hand.values()) {
//            if (val > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
    public static void main(String[] args) {
        String a = "RBYYBBRRB";
        String b = "YRBGB";
        ZumaGame z = new ZumaGame();
        Character[] characters = {'a','a', 'a'};
        List<Character> c = new ArrayList<>(Arrays.asList(characters));
//        z.cleanup(c);
//        int res = z.findMinStep(a, b);
//        System.out.println(res);
    }
}
