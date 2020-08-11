/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        StringBuilder sb = new StringBuilder(x + "");
        int length = sb.length();
        String front = "";
        String back = "";
        if (length % 2 == 0) {// 偶数位
            front = sb.substring(0, length / 2);
            back = sb.substring(length / 2);
            return front.equals(new StringBuilder(back).reverse().toString());
        } else {// 奇数位
            front = sb.substring(0, length / 2);
            back = sb.substring(length / 2 + 1);
            return front.equals(new StringBuilder(back).reverse().toString());
        }
    }
}
// @lc code=end
