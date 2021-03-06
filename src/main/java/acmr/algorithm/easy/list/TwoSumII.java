/**
 * 
 */
package acmr.algorithm.easy.list;

import acmr.algorithm.util.Tools;

/**
 * @author guohz
 * @date 2020年10月10日
 * @description TwoSumII
 * 
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

	函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
	
	说明:
	
	返回的下标值（index1 和 index2）不是从零开始的。
	你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
	示例:
	
	输入: numbers = [2, 7, 11, 15], target = 9
	输出: [1,2]
	解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumII {
	
    public static int[] twoSum(int[] numbers, int target) {
    	int[] ret = new int[2];
    	for(int i = 0; i < numbers.length; i++) {
    		int findValue = target - numbers[i];
    		boolean find = false;
    		int left = i + 1;
    		int right = numbers.length - 1;
    		while(left <= right) {
    			int mid = (right + left) / 2 ;
    			if(numbers[mid] == findValue) {
    				ret[0] = i + 1;
    				ret[1] = mid + 1;
    				find = true;
    				break;
    			} else {
    				if(numbers[mid] < findValue) {
    					left = mid + 1;
    				} else {
    					right = mid - 1;
    				}
    			}
    		}
    		if(find) break;
    	}
    	return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Tools.arrayToString(TwoSumII.twoSum(new int[] {-2,1,3,6,7,10,11,15}, 9)));
		System.out.println(Tools.arrayToString(TwoSumII.twoSum(new int[] {2,3,4}, 6)));
	}

}
