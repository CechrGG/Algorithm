package acmr.algorithm.medium.array;

import java.util.*;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/6/22
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeArr = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return threeArr;
        }

        Arrays.sort(nums);
        Set<Integer> repeat1 = new HashSet<>();
        for(int i = 0 ; i < nums.length - 2; i++) {
            if(repeat1.contains(nums[i])) {
                continue;
            }
            Set<Integer> repeat2 = new HashSet<>();
            for(int j = i + 1; j < nums.length - 1; j++) {
                if(repeat2.contains(nums[j])) {
                    continue;
                }
                int target = -(nums[i] + nums[j]);
                int right = nums.length - 1;
                int find = nums[right];
                if(target > find){
                    continue;
                }
                int left = j + 1;
                while (left <= right) {
                    int index = (left + right + 1) / 2 ;
                    find = nums[index];
                    if(target == find) {
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(target);
                        threeArr.add(arr);
                        repeat1.add(nums[i]);
                        repeat2.add(nums[j]);
                        break;
                    }
                    if(target < find) {
                        right = index - 1;
                    } else {
                        left = index + 1;
                    }
                }
            }
        }
        return threeArr;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,-1,-2,-3,-4,-5,0};
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
    }
}
