/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        /** 自己实现 */
        // if (nums == null || nums.length == 0)
        // return 0;
        // int result = nums.length;
        // int pre = nums[0];
        // int k = result;
        // for (int i = 1; i < nums.length; i++) {
        // k--;
        // if (k <= 0) break;
        // int num = nums[i];
        // if (num == pre) {
        // result--;
        // for (int j = i + 1; j < nums.length; j++) {
        // nums[j - 1] = nums[j];
        // }
        // i--;
        // pre = nums[i];
        // } else
        // pre = num;
        // }
        // return result;
        /** 官方双指针法 */
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
// @lc code=end
