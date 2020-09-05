/**
 * 
 */
package acmr.algorithm.easy;

/**
 * @author guoguo
 * @date 2020年9月5日
 * @Description SpuareRoot
 * 
 * 	实现 int sqrt(int x) 函数。

	计算并返回 x 的平方根，其中 x 是非负整数。
	
	由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	
	示例 1:
	
	输入: 4
	输出: 2
	示例 2:
	
	输入: 8
	输出: 2
	说明: 8 的平方根是 2.82842..., 
	     由于返回类型是整数，小数部分将被舍去。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/sqrtx
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpuareRoot69 {
	
    public static int mySqrt(int x) {
    	if(x < 0) {
    		return -1;
    	}
    	int low = 0;
    	int top = x;
    	int ret = -1;
    	while(low <= top) {
    		int part = low + (top - low) / 2;
//    		System.out.print((long)part*part + ",");
    		if((long)part*part <= x) {
    			ret = part;
    			low = part + 1;
    		}else{
    			top = part - 1;
    		}
    	}
    	return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SpuareRoot69.mySqrt(-1));
		System.out.println(SpuareRoot69.mySqrt(0));
		System.out.println(SpuareRoot69.mySqrt(1));
		System.out.println(SpuareRoot69.mySqrt(2));
		System.out.println(SpuareRoot69.mySqrt(8));
		System.out.println(SpuareRoot69.mySqrt(16));
		System.out.println(SpuareRoot69.mySqrt(25));
		System.out.println(SpuareRoot69.mySqrt(256));
		System.out.println(SpuareRoot69.mySqrt(255));
		System.out.println(SpuareRoot69.mySqrt(2147395599));
	}

}
