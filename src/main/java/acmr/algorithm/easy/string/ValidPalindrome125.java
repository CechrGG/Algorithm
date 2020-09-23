/**
 * 
 */
package acmr.algorithm.easy.string;

/**
 * @author guohz
 * @date 2020年9月23日
 * @description ValidPalindrome125
 * 
 * 	给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

	说明：本题中，我们将空字符串定义为有效的回文串。
	
	示例 1:
	
	输入: "A man, a plan, a canal: Panama"
	输出: true
	示例 2:
	
	输入: "race a car"
	输出: false
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/valid-palindrome
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); i++) {
    		char ci = s.charAt(i);
    		if((ci >=48 && ci <= 57) || (ci >= 65 && ci <= 90) || (ci >= 97 && ci <= 122)) {
    			sb.append(ci);
    		}
    	}
    	int length = 0;
    	if(sb.length() / 2 == 0) {
    		length = sb.length() / 2;
    	} else {
    		length = sb.length() / 2 + 1;
    	}
    	for(int i = 0; i < length; i++) {
    		int abs = Math.abs(sb.charAt(i)-sb.charAt(sb.length() - i - 1));
    		if(abs != 0 && abs != 32 ) {
    			return false;
    		}
    	}
    	return true;
    }
    
    //已有轮子
    public static boolean isPalindrome2(String s) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); i++) {
    		char ci = s.charAt(i);
    		if(Character.isLetterOrDigit(ci)) {
    			sb.append(Character.toLowerCase(ci));
    		}
    	}
    	StringBuilder sbReverse = new StringBuilder(sb).reverse();
    	if(sb.toString().equals(sbReverse.toString()))
    		return true;
    	else 
    		return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ValidPalindrome125.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(ValidPalindrome125.isPalindrome2("A man, a plan, a canal: Panama"));
	}

}
