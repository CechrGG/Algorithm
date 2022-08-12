package acmr.algorithm.medium.array;

import java.util.Arrays;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/8/12
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstLastPositionofElementinSortedArray34 {

    /**
     * 暴力
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] fl = {-1, -1};
        for(int i = 0; i < nums.length; i++) {
            if(fl[0] == -1 && target == nums[i]) {
                fl[0] = i;
                if(nums[nums.length - 1] == target) {
                    fl[1] = nums.length - 1;
                    break;
                }
            }
            if(fl[0] != -1 && target < nums[i]) {
                fl[1] = i - 1;
                break;
            }
        }
        return fl;
    }

    /**
     * 二分
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRangeBin(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        return new int[]{bSearch(nums, target, true), bSearch(nums, target, false)};
    }

    public static int bSearch(int[] nums, int target, boolean findMin) {
        int left = 0;
        int right = nums.length - 1;
        int find = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) {
                find = mid;
                if(findMin) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] nums2 = {1};
        int[] nums3 = {7,7,7,7,7,7};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
        System.out.println(Arrays.toString(searchRange(nums, 6)));
        System.out.println(Arrays.toString(searchRange(nums2, 1)));
        System.out.println(Arrays.toString(searchRange(nums2, 0)));
        System.out.println(Arrays.toString(searchRange(nums3, 7)));
        System.out.println(Arrays.toString(searchRangeBin(nums, 8)));
        System.out.println(Arrays.toString(searchRangeBin(nums, 6)));
        System.out.println(Arrays.toString(searchRangeBin(nums2, 1)));
        System.out.println(Arrays.toString(searchRangeBin(nums2, 0)));
        System.out.println(Arrays.toString(searchRangeBin(nums3, 7)));
        int[] nums4 = {2,2};
        System.out.println(Arrays.toString(searchRangeBin(nums4, 2)));
    }
}
