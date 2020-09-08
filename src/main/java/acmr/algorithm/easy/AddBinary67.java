/**
 * 
 */
package acmr.algorithm.easy;

import java.math.BigInteger;
import java.util.Stack;

/**
 * @author guohz
 * @date 2020年8月19日
 * @description AddBinary67
 * 	给你两个二进制字符串，返回它们的和（用二进制表示）。

	输入为 非空 字符串且只包含数字 1 和 0。
	示例 1:
	
	输入: a = "11", b = "1"
	输出: "100"
	示例 2:
	
	输入: a = "1010", b = "1011"
	输出: "10101"
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/add-binary
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary67 {
	
	//别人的轮子真的好用啊
    public static String addBinary(String a, String b) {
    	return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
    
    public static String addBinary2(String a, String  b) {
    	int length = Math.max(a.length(), b.length());
    	if(length != a.length()) {
    		StringBuffer sb = new StringBuffer("");
    		for(int i = 0; i < length - a.length(); i++) {
    			sb.append('0');
    		}
    		sb.append(a);
    		a = sb.toString();
    	}
    	if(length != b.length()) {
    		StringBuffer sb = new StringBuffer("");
    		for(int i = 0; i < length - b.length(); i++) {
    			sb.append('0');
    		}
    		sb.append(b);
    		b = sb.toString();
    	}
    	boolean carry = false;
    	StringBuilder sb = new StringBuilder();
    	for( int i = length; i >= 1; i--) {
    		int ca = Integer.valueOf(a.substring(i-1, i));
    		int cb = Integer.valueOf(b.substring(i-1, i));
    		int ret = 0;
    		if(!carry) {
	    		if((ca & cb) == 1) {
	    			carry = true;
	    		} else {
	    			ret = ca + cb;
	    		}
    		} else {
    			if((ca | cb) == 0) {
    				carry = false;
    				ret = 1;
    			} else {
    				carry = true;
    				if((ca & cb) == 1) {
    					ret = 1;
    				} else {
    					ret = 0;
    				}
    			}
    		}
    		sb.insert(0, ret);
    	}
    	if(carry) {
    		sb.insert(0, 1);
    	}
    	return sb.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BigInteger("110", 2).toString());
		System.out.println(AddBinary67.addBinary("1110", "11"));
		System.out.println(AddBinary67.addBinary2("1110", "11"));
	}

}
