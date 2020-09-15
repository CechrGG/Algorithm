/**
 * 
 */
package acmr.algorithm.easy.list;

/**
 * @author guohz
 * @date 2020年8月18日
 * @description CountAndSay38
 * 
 * 	给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

	注意：整数序列中的每一项将表示为一个字符串。
	
	「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
	
	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	第一项是数字 1
	
	描述前一项，这个数是 1 即 “一个 1 ”，记作 11
	
	描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
	
	描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
	
	描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/count-and-say
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountAndSay38 {
	
    public static String countAndSay(int n) {
    	if(n < 1 || n >30) {
    		return "";
    	}
    	if(n == 1) {
    		return "1";
    	}
    	
		String strPre = countAndSay(n - 1);
		//这里如果用字符串拼接，效率大打折扣
		StringBuffer sb = new StringBuffer();
		if(strPre.length() > 0) {
    		int count = 0;
    		char temp = strPre.charAt(0);
    		for(int j = 0; j < strPre.length(); j++) {
    			char charAt = strPre.charAt(j);
    			if(charAt == temp) {
    				count++;
    			} else {
    				sb.append(count);
    				sb.append(temp);
    				count = 1;
    				temp = charAt;
    			}
    		}

			sb.append(count);
			sb.append(temp);
		}
		return sb.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 32; i++) {
			System.out.println(CountAndSay38.countAndSay(i));
		}
	}

}
