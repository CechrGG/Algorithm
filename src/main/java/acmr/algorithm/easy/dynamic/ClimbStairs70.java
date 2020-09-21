/**
 * 
 */
package acmr.algorithm.easy.dynamic;

/**
 * @author guoguo
 * @date 2020年9月5日
 * @Description ClimbStairs70
 * 
 * 	假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

	每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	
	注意：给定 n 是一个正整数。
	
	示例 1：
	
	输入： 2
	输出： 2
	解释： 有两种方法可以爬到楼顶。
	1.  1 阶 + 1 阶
	2.  2 阶
	示例 2：
	
	输入： 3
	输出： 3
	解释： 有三种方法可以爬到楼顶。
	1.  1 阶 + 1 阶 + 1 阶
	2.  1 阶 + 2 阶
	3.  2 阶 + 1 阶
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/climbing-stairs
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs70 {
	

	//递归次数过多回导致超时，递归时间复杂度高
    public int climbStairs(int n) {
    	if(n <= 0) {
    		return -1;
    	}
    	if(n == 1) {
    		return 1;
    	}
    	if(n == 2) {
    		return 2;
    	}
    	return climbStairs(n - 1) + climbStairs(n - 2); 
    }
    
    public int climbStairs2(int n) {
    	if(n <= 0) {
    		return -1;
    	}
    	int pre1 = 0, pre2 = 0, ret = 1;
    	for(int i = 0; i < n; i++) {
    		pre1 = pre2;
    		pre2 = ret;
    		ret = pre1 + pre2;
    	}
    	return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbStairs70 cs = new ClimbStairs70();
		System.out.println(cs.climbStairs(1));
		System.out.println(cs.climbStairs(2));
		System.out.println(cs.climbStairs(3));
		System.out.println(cs.climbStairs(4));
		System.out.println(cs.climbStairs(5));
	}

}
