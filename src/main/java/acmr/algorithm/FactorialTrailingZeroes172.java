/**
 * 
 */
package acmr.algorithm;

import java.math.BigInteger;

/**
 * @author guoguo
 * @date 2020年10月17日
 * @Description FactorialTrailingZeroes172
 * 
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。

	示例 1:
	
	输入: 3
	输出: 0
	解释: 3! = 6, 尾数中没有零。
	示例 2:
	
	输入: 5
	输出: 1
	解释: 5! = 120, 尾数中有 1 个零.
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FactorialTrailingZeroes172 {
	
    public static int trailingZeroes(int n) {
    	BigInteger bi = BigInteger.valueOf(1);
    	for(int i = n; i > 0; i--) {
    		bi = bi.multiply(BigInteger.valueOf(i));
    	}
    	String str = bi.toString();
    	int ret = 0;
    	for(int i = str.length() - 1; i >= 0; i--) {
    		if(str.charAt(i) == '0') {
    			ret++;
    		} else {
    			break;
    		}
    	}
    	return ret;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FactorialTrailingZeroes172.trailingZeroes(3));
		System.out.println(FactorialTrailingZeroes172.trailingZeroes(5));
		System.out.println(FactorialTrailingZeroes172.trailingZeroes(100));
		System.out.println(FactorialTrailingZeroes172.trailingZeroes(1000));
	}

}
