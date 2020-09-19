/**
 * 
 */
package acmr.algorithm.easy.tree;

import acmr.algorithm.common.TreeNode;

/**
 * @author guoguo
 * @date 2020年9月19日
 * @Description BST108
 * 
 * 	将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

	本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
	
	示例:
	
	给定有序数组: [-10,-3,0,5,9],
	
	一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
	
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BST108 {
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums == null || nums.length <= 0) {
    		return null;
    	}
    	int rootIndex = nums.length / 2;
    	TreeNode root = new TreeNode(nums[rootIndex]);
    	int[] left = new int[rootIndex];
    	int[] right = new int[nums.length - rootIndex - 1];
    	for(int i = 0; i < rootIndex; i++) {
    		left[i] = nums[i];
    	}
    	root.left = sortedArrayToBST(left);
    	int rightIndex = 0;
    	for(int i = rootIndex + 1; i < nums.length; i++) {
    		right[rightIndex] = nums[i];
    		rightIndex++;
    	}
    	root.right = sortedArrayToBST(right);
    	return root;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
