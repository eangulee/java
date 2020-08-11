/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode next = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                next.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                next.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            next = next.next;
        }
        // while(l1 != null){
        // next.next = new ListNode(l1.val);
        // l1 = l1.next;
        // next = next.next;
        // }
        // while(l2 != null){
        // next.next = new ListNode(l2.val);
        // l2 = l2.next;
        // next = next.next;
        // }
        next.next = l1 == null ? l2 : l1;
        return node.next;
    }
}
// @lc code=end
