/**
 * 
 */
package acmr.algorithm.easy.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guoguo
 * @date 2020年10月17日
 * @Description MajorityElement
 * 
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

	你可以假设数组是非空的，并且给定的数组总是存在多数元素。
	示例 1:
	
	输入: [3,2,3]
	输出: 3
	示例 2:
	
	输入: [2,2,1,1,1,2,2]
	输出: 2
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/majority-element
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement169 {
	
    public static int majorityElement(int[] nums) {
    	int ret = Integer.MIN_VALUE;
        if(nums.length == 1) {
            ret = nums[0];
        } else {     
    	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int num : nums) {
                if(map.containsKey(num)) {
                    int count = map.get(num);
                    if(count + 1 > nums.length / 2) {
                        ret = num;
                        break;
                    }
                    map.put(num, count + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
    	return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MajorityElement169.majorityElement(new int[] {3,2,3}));
		System.out.println(MajorityElement169.majorityElement(new int[] {2,2,1,1,1,2,2}));
		System.out.println(MajorityElement169.majorityElement(new int[] {2,2,1,1,1,2,2,1,1,1,1,1,1,1}));
	}

}
