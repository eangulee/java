/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int x = Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);

        while (y != 0) {
            int carray = x & y;
            x = x ^ y;
            y = carray << 1;
        }
        return Integer.toBinaryString(x);
    }
}
// @lc code=end
