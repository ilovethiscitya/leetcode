/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (23.02%)
 * Total Accepted:    122.2K
 * Total Submissions: 529.3K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * Output: []
 * 
 * 
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length;i++) {
            String cur = words[i];
            int idx = s.indexOf(cur);
            if(dfs(s.substring(idx + 1), i, idx + cur.length(), words)) {
                res.add(idx);
            }
        }
        return res;
    }
    private boolean dfs(String s, int wordsIdx, int startIdx, String[] words) {
        if(s == null || s.length() == 0) return true;
        for(int i = 0; i < words.length; i++) {
            if(i == wordsIdx) continue;
            String cur = words[i];
            if(s.indexOf(cur) == startIdx + 1) {
                if(dfs(s.substring(startIdx + 1), i, startIdx + cur.length(), words)) {
                    return true;
                }
            }
        }
        return false;
    }
}
