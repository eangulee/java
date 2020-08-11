import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0)
            return false;
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('}', '{');
                put(']', '[');
                put(')', '(');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != map.get(ch))
                    return false;
            } else {
                stack.push(ch);
            }
        }
        return stack.empty();
    }

}
// @lc code=end
