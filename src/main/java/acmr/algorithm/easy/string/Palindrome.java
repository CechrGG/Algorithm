package acmr.algorithm.easy.string;

/**
 * @author guoguo
 * @date 2020年8月14日
 * @Description Palindrome
 * 
 *	 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	
	示例 1:
	
	输入: 121
	输出: true
	示例 2:
	
	输入: -121
	输出: false
	解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	示例 3:
	
	输入: 10
	输出: false
	解释: 从右向左读, 为 01 。因此它不是一个回文数。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/palindrome-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Palindrome {
	
	//字符串
    public static boolean isPalindrome(int x) {
    	String str = String.valueOf(x);
    	int length = 0;
    	if(str.length() / 2 == 0) {
    		length = str.length() / 2;
    	} else {
    		length = str.length() / 2 + 1;
    	}
    	for(int i = 0; i < length; i++) {
    		if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    //计算
    public static boolean isPalindrome2(int x) {
    	if(x < 0 || (x != 0 && x % 10 == 0)) {
    		return false;
    	}
    	
    	int ret = 0;
    	while (x > ret) {
    		ret = ret * 10 + x % 10;
    		x = x / 10;
    	}
    	
    	return x == ret || x == ret / 10;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Palindrome.isPalindrome(542464245));
		System.out.println(Palindrome.isPalindrome2(123321));
	}

}
