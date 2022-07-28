package acmr.algorithm.medium.string;

import java.util.Stack;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/28
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidParentheses32 {

    public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
                continue;
            }
            stack.pop();
            if(stack.empty()) {
                stack.push(i);
            } else {
                count = Math.max(count, i - stack.peek());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("((((())))((((()))))((())))))"));
        System.out.println(longestValidParentheses("()(()"));
    }
}
