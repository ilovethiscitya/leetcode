import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//class TrieNode{
//    public char val;
//    public boolean isWord;
//    public TrieNode[] children = new TrieNode[26];
//    public TrieNode() {}
//    TrieNode(char c) {
//        TrieNode node = new TrieNode();
//        node.val = c;
//    }
//}
//
//
//
//public class implementTrie {
//
//    /**
//     * 208. Implement Trie (Prefix Tree)
//     */
//
//    TrieNode root;
//    List<String> res;
//    /** Initialize your data structure here. */
//    public implementTrie() {
//        root = new TrieNode();
//    }
//
//    // time : O(n)  n: word.length();
//    // O(num of TrieNode * 26) = O(num of Words * word.length() * 26)
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode node = root;
//        for (int i = 0; i < word.length(); i++) {
//            int j = word.charAt(i) - 'a';
//            if (node.children[j] == null) {
//                node.children[j] = new TrieNode();
//            }
//            node = node.children[j];
//        }
//        node.isWord = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        TrieNode node = root;
//        for (int i = 0; i < word.length(); i++) {
//            int j = word.charAt(i) - 'a';
//            if (node.children[j] == null) return false;
//            node = node.children[j];
//        }
//        return node.isWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TrieNode node = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            int j = prefix.charAt(i) - 'a';
//            if (node.children[j] == null) return false;
//            node = node.children[j];
//        }
//        return true;
//    }
//}


//class TrieNode {
//    private final int R = 26;
//    private final TrieNode[] children;
//    private String item;
//    public TrieNode() {
//        children = new TrieNode[R];
//        item = "";
//    }
//
//    public String getItem() {
//        return item;
//    }
//
//    public void setItem(String item) {
//        this.item = item;
//    }
//
//    public TrieNode[] getChildren() {
//        return children;
//    }
//
//    public TrieNode getChild(int i) {
//        if (i >= 26 || i < 0) throw new IllegalArgumentException();
//        return children[i];
//    }
//    public void setChild(int i, TrieNode node) {
//        children[i] = node;
//    }
//}
//public class Trie {
//    private TrieNode root;
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        TrieNode curr = root;
//        for (char c : word.toCharArray()) {
//            if (curr.getChild(c - 'a') == null)
//                curr.setChild(c - 'a', new TrieNode());
//            curr = curr.getChild(c - 'a');
//        }
//        curr.setItem(word);
//    }
//    public boolean search(String word) {
//        TrieNode curr = root;
//        for (char c : word.toCharArray()) {
//            if (curr.getChild(c - 'a') == null) return false;
//            curr = curr.getChild(c - 'a');
//        }
//        return curr.getItem().equals(word);
//    }
//
//    public boolean startsWith(String prefix) {
//        TrieNode curr = root;
//        for (char c : prefix.toCharArray()) {
//            if (curr.getChild(c - 'a') == null) return false;
//            curr = curr.getChild(c - 'a');
//        }
//        return true;
//    }
//}



