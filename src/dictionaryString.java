/**
 * Created by jianzhe on 11/4/18.
 */
public class dictionaryString {
    public TrieNode root;
    public dictionaryString() {
        root = new TrieNode();
        root.val = ' ';
    }
    public void buildTrie(String dictionary) {
        String[] words = dictionary.split(" ");
        TrieNode ws = root;
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if(ws.children[cur - 'a'] == null) {
                    ws.children[cur - 'a'] = new TrieNode(cur);
                }
                ws = ws.children[cur - 'a'];
            }
            ws.isWord = true;
        }
    }
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
}
class TrieNode{
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    TrieNode() {}
    public TrieNode(char c){
        this.val = c;
    }
}
