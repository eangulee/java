/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs == null || strs.length == 0)
            return prefix;
        String first = strs[0];
        if (strs.length == 1)
            return first;
        if (first.equals(""))
            return first;
        int count = 1;
        String code = first.substring(0, count);
        while (true) {
            for (String str : strs) {
                if (!str.startsWith(code))
                    return prefix;
            }
            prefix = code;
            if (count == first.length())
                break;
            count++;
            code = first.substring(0, count);
        }
        return prefix;
    }
}
// @lc code=end
