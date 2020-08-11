/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        if (x == 0)
            return x;
        boolean negative = x < 0;
        String str = x + "";

        StringBuilder sb = new StringBuilder(str);
        if (negative)
            sb.delete(0, 1);
        // 作为字符串反转
        str = sb.reverse().toString();

        long num = Long.parseLong(str);
        num = num * (negative ? -1 : 1);
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
            return 0;
        return (int) num;
    }
}
// @lc code=end
