/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (31.11%)
 * Total Accepted:    379.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int startIndex = -1;
        for(int i = 0; i < hLen; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while(j < nLen) {
                    if(haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if(j == nLen) return i;
            }
        }
        return startIndex;
    }
}
