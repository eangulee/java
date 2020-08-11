/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        /** 自行实现 */
        // int result = nums.length;
        // int k = result;
        // for (int i = 0; i < nums.length; i++) {
        // k--;
        // if (k < 0)
        // break;
        // if (nums[i] == val) {
        // result--;
        // for (int j = i + 1; j < nums.length; j++) {
        // nums[j - 1] = nums[j];
        // }
        // i--;
        // }
        // }
        // return result;
        /** 官方双指针法 */
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
// @lc code=end
