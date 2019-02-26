/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (52.84%)
 * Total Accepted:    298.9K
 * Total Submissions: 564K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        return dfs('(', 1, 0, n);
    }
    private List<String> dfs(char par, int numLeft, int numRight, int n) {
        List<String> result = new ArrayList<>();
        if(numLeft == n && numLeft == numRight) {
            result.add(")");
            return result;
        }
        List<String> childrenResult = new ArrayList<>();
        if(numLeft < n) {
            childrenResult.addAll(dfs('(', numLeft + 1, numRight, n));
        }
        if(numRight < numLeft) {
            childrenResult.addAll(dfs(')', numLeft, numRight, n));
        }
        for(String s : childrenResult) {
            result.add(par + s);
        }
        return result;
    }
}
