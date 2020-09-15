/**
 * 
 */
package acmr.algorithm.easy.list;

/**
 * @author guohz
 * @date 2020年8月17日
 * @description SearchInsert35
 * 
 * 	给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

	你可以假设数组中无重复元素。
	
	示例 1:
	
	输入: [1,3,5,6], 5
	输出: 2
	示例 2:
	
	输入: [1,3,5,6], 2
	输出: 1
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/search-insert-position
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert35 {
	
	//直接查找，如果数组非常大，考虑到效率应该用二分法
    public static int searchInsert(int[] nums, int target) {
    	if(nums == null)
    		return 0;
    	int i = 0;
    	for(; i < nums.length; i++) {
    		if(nums[i] >= target) {
    			return i;
    		}
    	}
    	return i;
    }
    
    //二分法
    public static int searchInsertBinary(int[] nums, int target) {
    	if(nums == null) {
    		return 0;
    	}
    	int left = 0, right = nums.length - 1, mid = 0;
    	while(left <= right) {
    		mid = (right - left) / 2 + left;
    		if(target == nums[mid]) {
    			return mid;
    		} else if(target < nums[mid]) {
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
     	}
    	return left;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = new int[] {1,3,4,5,6};
		int[] nums = new int[100000000];
		for(int i = 0; i < 100000000; i++) {
			nums[i] = i;
		}
		long begin = System.currentTimeMillis();
		System.out.println(SearchInsert35.searchInsertBinary(nums, 50000));
		long end = System.currentTimeMillis();
		System.out.println((end - begin));
		

		begin = System.currentTimeMillis();
		System.out.println(SearchInsert35.searchInsert(nums, 50000));
		end = System.currentTimeMillis();
		System.out.println((end - begin));
	}

}
