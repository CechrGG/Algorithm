/**
 * 
 */
package acmr.algorithm.easy.list;

/**
 * @author guohz
 * @date 2020年9月24日
 * @description SingleNumber
 * 
 * 	给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

	说明：
	
	你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	
	示例 1:
	输入: [2,2,1]
	输出: 1
	
	示例 2:
	输入: [4,1,2,1,2]
	输出: 4
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/single-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber136 {
	
	/*不看答案想不到啊
	异或运算有以下三个性质。

	任何数和 00 做异或运算，结果仍然是原来的数，即 a ^ 0=a a^0=a。
	任何数和其自身做异或运算，结果是 00，即 a ^ a=0 。
	异或运算满足交换律和结合律，即 a ^ b ^ a=b ^ a ^ a=b ^ (a ^ a)=b ^0=b。
	*/
    public static int singleNumber(int[] nums) {
    	int single = 0;
    	for(int num : nums) {
    		single ^= num;
    	}
    	return single;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SingleNumber136.singleNumber(new int[] {4,1,2,1,2}));
		System.out.println(SingleNumber136.singleNumber(new int[] {2,1,2}));
		System.out.println(SingleNumber136.singleNumber(new int[] {2,2,4,4,1}));
		System.out.println(SingleNumber136.singleNumber(new int[] {1,3,1,-1,3}));
	}

}
