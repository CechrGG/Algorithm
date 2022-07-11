package acmr.algorithm.medium.array;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/8
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumCloest16 {

    /**
     * 暴力破解，超时了
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int abs = Integer.MAX_VALUE;
        int sum = 0;
        outer:
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    int tmpAbs = Math.abs(target - tmp);
                    if(abs > tmpAbs) {
                        abs = tmpAbs;
                        sum = tmp;
                    }
                    if(abs == 0) {
                        break outer;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,2,1,-4};
        int[] nums = {0, 0, 0};
        System.out.println(threeSumClosest(nums, 1));
    }
}
