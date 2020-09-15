/**
 * 
 */
package acmr.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.List;

import acmr.algorithm.common.TreeNode;
import acmr.algorithm.util.Tools;

/**
 * @author guohz
 * @date 2020年9月15日
 * @description BuildTree
 * 
 * 	根据一棵树的前序遍历与中序遍历构造二叉树。

	注意:
	你可以假设树中没有重复的元素。
	
	例如，给出
	
	前序遍历 preorder = [3,9,20,15,7]
	中序遍历 inorder = [9,3,15,20,7]
	返回如下的二叉树：
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree105 {
	
	//这个方法似乎有点耗时，有时间再考虑
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || preorder.length <= 0) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[0]);
    	int length = 0;
    	while(length < inorder.length && preorder[0] != inorder[length]) {
    		length++;
    	}
    	if(length >= inorder.length) {
    		return null;
    	}
    	int[] inleft = new int[length], preleft = new int[length];
    	int[] inright = new int[inorder.length - length - 1], preright = new int[inorder.length - length - 1];
    	for(int i = 1; i < preorder.length; i++) {
    		if(i <= length) {
    			preleft[i - 1] = preorder[i];
    		} else {
    			preright[i - length - 1] = preorder[i];
    		}
    	}
    	for(int i = 0; i < inorder.length; i++) {
    		if(i < length) {
    			inleft[i] = inorder[i];
    		} 
    		if(i > length){
    			inright[i - length - 1] = inorder[i];
    		}
    	}
    	root.left = buildTree(preleft, inleft);
    	root.right = buildTree(preright, inright);
    	
    	return root;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = BuildTree105.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
		TreeNode tree2 = BuildTree105.buildTree(new int[] {1,2}, new int[] {2,1});
		Tools.printPreTree(tree);
		System.out.println();
		Tools.printMidTree(tree);
	}

}
