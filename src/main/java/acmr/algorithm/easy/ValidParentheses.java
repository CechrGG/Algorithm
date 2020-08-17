/**
 * 
 */
package acmr.algorithm.easy;

import java.util.Stack;

/**
 * @author guoguo
 * @date 2020年8月14日
 * @Description ValidParentheses
 * 	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

	有效字符串需满足：
	
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/valid-parentheses
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>(); 
		for(int i = 0; i < s.length(); i++) {
			char chari = s.charAt(i);
			if(chari != '(' && chari != ')' && chari != '{' && chari != '}' && chari != '[' && chari != ']') {
				return false;
			}
			if(chari == '(' || chari == '{' || chari == '[') {
				stack.push(chari);
			} else {
				if(stack.size() == 0) {
					return false;
				}
				Character peek = stack.peek();
				if(ValidParentheses.isMatch(peek, chari)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if(stack.size() == 0) {
			return true;
		} else {
			return false;
		}
    }
	
	public static boolean isMatch(char pre, char next) {
		if((pre == '(' && next == ')') || (pre == '{' && next == '}') || (pre == '[' && next == ']')) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ValidParentheses.isValid("()"));
		System.out.println(ValidParentheses.isValid("()[]{}"));
		System.out.println(ValidParentheses.isValid("(]"));
		System.out.println(ValidParentheses.isValid("([)]"));
		System.out.println(ValidParentheses.isValid("{[]}"));
	}

}
