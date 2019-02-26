/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (35.11%)
 * Total Accepted:    167K
 * Total Submissions: 474.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // if(head == null) return null;
        // Stack<ListNode> stack = new Stack<>();
        // ListNode cur = head;
        // // 如果没有到k的话就不reverse了
        // boolean isReachK = true;
        // for(int i = 0; i < k; i++) {
        //     stack.push(cur);
        //     cur = cur.next;
        //     if(cur == null) {
        //         isReachK = false;
        //         break;
        //     }
        // }
        // ListNode next = isReachK ? reverseKGroup(cur, k) : cur;
        // ListNode dummy = new ListNode(0);
        // ListNode prev = dummy;
        // while(!stack.isEmpty()){
        //     prev.next = stack.pop();
        //     prev = prev.next;
        // }
        // prev.next = next;
        // return dummy.next;
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if(count == k) {
            cur = reverseKGroup(cur, k);
            while(count -- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
