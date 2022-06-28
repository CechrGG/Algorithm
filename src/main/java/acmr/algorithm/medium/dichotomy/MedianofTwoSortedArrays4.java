package acmr.algorithm.medium.dichotomy;

import java.util.Arrays;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/6/27
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *  
 *
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * 通过次数739,305提交次数1,783,900
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianofTwoSortedArrays4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        int pos1 = 0, pos2 = 0;
        while (pos1 + pos2 < length) {
            if(pos1 == nums1.length) {
                nums[pos1 + pos2] = nums2[pos2];
                pos2++;
                continue;
            }
            if(pos2 == nums2.length) {
                nums[pos1 + pos2] = nums1[pos1];
                pos1++;
                continue;
            }
            if(nums1[pos1] < nums2[pos2]) {
                nums[pos1 + pos2] = nums1[pos1];
                pos1++;
            } else {
                nums[pos1 + pos2] = nums2[pos2];
                pos2++;
            }
        }
        double median;
        if(length % 2 == 0) {
            median = (double) (nums[length/2 - 1] + nums[length / 2]) / 2;
        } else {
            median = nums[length / 2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,9,10};
//        int[] nums1 = {5,6,7,8,11,12};
        int[] nums2 = {2,3,4};
//        System.out.println(Arrays.toString(findMedianSortedArrays(nums1, nums2)));
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
