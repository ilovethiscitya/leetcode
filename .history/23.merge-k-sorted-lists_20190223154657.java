/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (32.65%)
 * Total Accepted:    338.2K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0 || lists == null) return null;
        PriorityQueue<ListNode> minQueue = new PriorityQueue<>(n, (o1, o2) -> {
            return Integer.compare(o1.val, o2.val);
        });
        for(ListNode list : lists) {
            minQueue.add(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(!minQueue.isEmpty()) {
            ListNode next = minQueue.pop();
            
        }
    }
}
