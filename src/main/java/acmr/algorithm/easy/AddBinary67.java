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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BigInteger("110", 2).toString());
		System.out.println(AddBinary67.addBinary("1010", "1011"));
	}

}
