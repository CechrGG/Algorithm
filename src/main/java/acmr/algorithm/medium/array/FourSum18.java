package acmr.algorithm.medium.array;

import java.util.*;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/11
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourArr = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return fourArr;
        }

        Arrays.sort(nums);
        Set<String> numSet = new HashSet<>();
        for(int i = 0; i < nums.length - 3; i++) {
            if(nums[i] > 0 && nums[i] > target) {
                break;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                int twoSum = nums[i] + nums[j];
                if(twoSum > 0 && twoSum > target) {
                    break;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int tmp = twoSum + nums[left] + nums[right];
                    if(tmp == target) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        String numStr = integers.toString();
                        if(!numSet.contains(numStr)) {
                            numSet.add(numStr);
                            fourArr.add(integers);
                        }
                        left++;
                        right--;
                    } else if(tmp > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return fourArr;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int[] nums2 = {2,2,2,2,2};
        int[] nums3 = {1,-2,-5,-4,-3,3,3,5};
        int[] nums4 = {-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
        System.out.println(fourSum(nums, 0));
        System.out.println(fourSum(nums2, 8));
        System.out.println(fourSum(nums3, -11));
        System.out.println(fourSum(nums4, 294967296));
    }
}
