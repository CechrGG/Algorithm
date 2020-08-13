/**
 * 
 */
package acmr.algorithm.easy;

import java.util.Stack;

/**
 * @author guohz
 * @date 2020年8月13日
 * @description Reverse
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

	示例 1:
	输入: 123
	输出: 321
	 示例 2:
	输入: -123
	输出: -321
	示例 3:
	输入: 120
	输出: 21
	注意:
	假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-integer
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {
	
	//字符串
	public static int reverse(int x) {
		String str = String.valueOf(x);
		StringBuilder ret = new StringBuilder();
		if(x < 0) {
			ret.append('-');
			str = str.substring(1, str.length());
		}
		for(int i = str.length() - 1; i >= 0; i--) {
			ret.append(str.charAt(i));
		}
		
		int retInt = 0;
		try {
			retInt = Integer.parseInt(ret.toString());
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return retInt;
	}
	
	//栈
	public static int reverseByStack(int x) {
		String str = String.valueOf(x);
		boolean unsigned = true;
		if(x < 0) {
			unsigned = false;
			str = str.substring(1, str.length());
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		StringBuilder ret = new StringBuilder();
		while(!stack.isEmpty()) {
			ret.append(stack.pop());
		}
		if(!unsigned) {
			ret.insert(0, '-');
		}
		int retInt = 0;
		try {
			retInt = Integer.parseInt(ret.toString());
		} catch(Exception e) {
			//e.printStackTrace();
		}
		return retInt;
		
	}
	
	//计算
	public static int reverseByOpr(int x) {
		int ret = 0;
		while(x != 0) {
			int remainder = x % 10;
			if(ret > 214748364  || (ret == 214748364 && remainder > 7)) {
				ret = 0;
				break;
			}
			if(ret < -214748364 || (ret == -214748364 && remainder < -8)) {
				ret = 0;
				break;
			}
			ret = ret * 10 + remainder;
			x = x / 10;
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Reverse.reverse(-1200));
		System.out.println(Reverse.reverseByStack(12345));
		System.out.println(Reverse.reverseByOpr(1200));
	}

}
