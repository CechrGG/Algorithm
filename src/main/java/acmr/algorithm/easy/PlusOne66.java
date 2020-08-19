/**
 * 
 */
package acmr.algorithm.easy;

import java.util.Stack;

import acmr.algorithm.util.Tools;

/**
 * @author guohz
 * @date 2020年8月19日
 * @description PlusOne66
 * 
 * 	给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	
	你可以假设除了整数 0 之外，这个整数不会以零开头。
	
	示例 1:
	
	输入: [1,2,3]
	输出: [1,2,4]
	解释: 输入数组表示数字 123。
	示例 2:
	
	输入: [4,3,2,1]
	输出: [4,3,2,2]
	解释: 输入数组表示数字 4321。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/plus-one
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne66 {
	
	//I'm so stupid ...
    public static int[] plusOne(int[] digits) {
    	if(digits == null || digits.length <= 0 || (digits.length > 1 && digits[0] == 0)) {
    		return digits;
    	}
    	Stack<Integer> stack = new Stack<Integer>();
		boolean plus = true;
    	for(int i = digits.length - 1; i >= 0; i--) {
    		if(plus) {
        		int last = digits[i] + 1;
        		if(last >= 10) {
            		stack.push(0);
        			if(i == 0) {
        				stack.push(1);
        			}
        			plus = true;
        		} else {
        			stack.push(last);
        			plus = false;
        		}
    		} else {
    			stack.push(digits[i]);
    		}
    	}
    	
    	int[] ret = new int[stack.size()];
    	for(int i = 0; i < ret.length; i++) {
    		ret[i] = stack.pop();
    	}
    	return ret;
    }
    
    
    //Easy ...
    public static int[] plusOneEasy(int[] digits) {
    	if(digits == null || digits.length <= 0 || (digits.length > 1 && digits[0] == 0)) {
    		return digits;
    	}
    	for(int i = digits.length - 1; i >= 0; i--) {
    		digits[i]++;
    		digits[i] = digits[i] % 10;
    		if(digits[i] != 0) {
    			return digits;
    		}
    	}
    	
    	digits = new int[digits.length + 1];
    	digits[0] = 1;
    	
    	return digits;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = new int[] { 1, 2, 2, 3, 4};
		digits = new int[digits.length + 1];
		digits[0] = 1;
		int[] arr = new int[10];
		System.out.println(Tools.arrayToString(digits));
		System.out.println(Tools.arrayToString(arr));
		System.out.println(Tools.arrayToString(PlusOne66.plusOne(digits)));
		System.out.println(Tools.arrayToString(PlusOne66.plusOneEasy(digits)));
	}

}
