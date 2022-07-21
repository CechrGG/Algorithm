package acmr.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/13
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses22 {

    private static final String OPEN = "(";
    private static final String CLOSE = ")";

    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        StringBuilder pth = new StringBuilder();
        backStrack(parenthesis, pth, 0, 0, n);
        return parenthesis;
    }

    public static void backStrack(List<String> parenthesis, StringBuilder currStr, int open, int close, int max) {
        if(currStr.length() == max * 2) {
            parenthesis.add(currStr.toString());
            return;
        }

        if(open < max) {
            currStr.append(OPEN);
            backStrack(parenthesis, currStr, open + 1, close, max);
            currStr.deleteCharAt(currStr.length() - 1);
        }
        if(close < open) {
            currStr.append(CLOSE);
            backStrack(parenthesis, currStr, open, close + 1, max);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
