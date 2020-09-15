/**
 * 
 */
package acmr.algorithm.easy.list;

/**
 * @author guohz
 * @date 2020年8月17日
 * @description RemoveDuplicates
 * 
 * 	给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
	示例 1:
	
	给定数组 nums = [1,1,2], 
	
	函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
	
	你不需要考虑数组中超出新长度后面的元素。
	示例 2:
	
	给定 nums = [0,0,1,1,1,2,2,3,3,4],
	
	函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
	
	你不需要考虑数组中超出新长度后面的元素。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates26 {

    public static int removeDuplicates(int[] nums) {
    	if(nums.length <= 0) {
    		return 0;
    	}
    	int i = 0;
    	for(int j = 1; j < nums.length; j++) {
    		if(nums[i] != nums[j]) {
    			i++;
    			nums[i] = nums[j];
    		}
    	}
    	return i + 1;
    	
    }
    
    //类似问题27
    public static int removeElement(int[] nums, int val) {
        if(nums.length < 0) return 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4,4,4,3,1,2,1,6};
//		int[] nums = new int[] {1,1,2};
//		System.out.println(RemoveDuplicates26.removeDuplicates(nums));
		System.out.println(RemoveDuplicates26.removeElement(nums, 1));
		for(int i = 0; i < nums.length ; i++) {
			System.out.print(nums[i] + ",");
		}
	}

}
