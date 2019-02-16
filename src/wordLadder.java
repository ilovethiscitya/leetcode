import java.util.*;

/**
 * Created by jianzhe on 2018/2/1.
 */
public class wordLadder {
    private static int ladderLength(String beginWord, String endWord, List<String> wordList){
        HashSet<String> set = new HashSet<String>(wordList);
        if(set.contains(beginWord)) {
            set.remove(beginWord);
        }
        int level = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                for(int k = 0; k < cur.length(); k++) {
                    char[] curChar = cur.toCharArray();
                    for(char j = 'a'; j <= 'z'; j++) {
                        curChar[k] = j;
                        String temp = new String(curChar);
                        if(set.contains(temp)) {
                            if(temp.equals(endWord)) {return level + 1;}
                            q.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.print(ladderLength(begin, end, list));
    }
}
