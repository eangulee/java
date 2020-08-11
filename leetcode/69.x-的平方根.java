/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // 牛顿迭代法
        /* 令f(x) = x^2 - a ,f'(x0) = (f(x) - f(x0))/(x-x0)(斜率)
         * f(x) = f(x0)+(x-x0)f'(x0)
         * 令f(x) = 0,得 f(x0)+(x-x0)f'(x0) = 0
         * x = x0 - f(x0)/f'(x0) = x0 - (x0^2 -a)/2x0 = (2x0^2-x0^2 + a)/2x0
         *   = 1/2(x0^2 +a)/x0 = 1/2(x0+ a/x0)
         */
        long x0 = x;
        while(x0 * x0 >x){
            x0 = (x0 +x /x0) /2;
        }
        return (int)x0;
    }
}
// @lc code=end

