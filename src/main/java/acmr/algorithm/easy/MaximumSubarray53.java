/**
 * 
 */
package acmr.algorithm.easy;

/**
 * @author guohz
 * @date 2020年8月18日
 * @description MaximumSubarray53
 * 
 * 	给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

	示例:
	
	输入: [-2,1,-3,4,-1,2,1,-5,4]
	输出: 6
	解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/maximum-subarray
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray53 {
	
	public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-2, 4, -1, 3};
		System.out.println(MaximumSubarray53.maxSubArray(nums));
	}

}
