/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {// 直到两条链都遍历结束
            int x = l1 == null ? 0 : l1.val;// 存在取值，不存在为0
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum > 9 ? 1 : 0;// 得到十位
            sum = sum % 10;// 得到个位
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1)
            cur.next = new ListNode(carry);

        return pre.next;
    }
}
// @lc code=end
