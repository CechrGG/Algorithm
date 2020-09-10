/**
 * 
 */
package acmr.algorithm.easy;

/**
 * @author guohz
 * @date 2020年9月9日
 * @description MergeSortedArray88
 * 
 * 
 *	 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

	说明:
	初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	 
	示例:
	
	输入:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3
	
	输出: [1,2,2,3,5,6]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/merge-sorted-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortedArray88 {
	
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(nums1.length < m + n) {
    		return;
    	}
    	if(m == 0) {
    		for(int i = 0; i < n; i++) {
    			nums1[i] = nums2[i];
    		}
    	} else {
	    	for(int i = n-1; i >= 0; i--) {
	    		for(int j  = m-1; j >= 0; j--) {
		    		if(nums2[i] > nums1[j]) {
		    			nums1[i + j + 1] = nums2[i];
		    			break;
		    		} else {
		    			nums1[i + j + 1] = nums1[j];
		    			m--;
			    		if(m == 0) {
			    			for(int rem = 0; rem <= i; rem++) {
			    				nums1[rem] = nums2[rem];
			    			}
			    		}
		    		}
	    		}
	    	}
    	}
    	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] {1,2,3,0,0,0};
//		int[] nums1 = new int[] {0,0,0};
		int[] nums2 = new int[] {2,5,6};
		MergeSortedArray88.merge(nums1, 3, nums2, 3);
		for(int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + ",");
		}
	}

}