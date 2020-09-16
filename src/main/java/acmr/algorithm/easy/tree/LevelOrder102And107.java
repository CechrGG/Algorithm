/**
 * 
 */
package acmr.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import acmr.algorithm.common.TreeNode;
import acmr.algorithm.util.Tools;

/**
 * @author guohz
 * @date 2020年9月16日
 * @description LevelOrderBottom
 * 
 * 102
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
	示例：
	二叉树：[3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回其层次遍历结果：
	
	[
	  [3],
	  [9,20],
	  [15,7]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 	
 * 107
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

	例如：
	给定二叉树 [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回其自底向上的层次遍历为：
	
	[
	  [15,7],
	  [9,20],
	  [3]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder102And107 {

	//102正序
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(root == null) {
    		return list;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
        	int count = queue.size();
        	List<Integer> row = new ArrayList<Integer>();
        	while(count > 0) {
        		TreeNode node = queue.poll();
        		row.add(node.val);
        		if(node.left != null) {
        			queue.offer(node.left);
        		}
        		if(node.right != null) {
        			queue.offer(node.right);
        		}
        		count--;
        	}
        	list.add(row);
    	}
    	return list;
    }
    
    //107倒序
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	Stack<List<Integer>> stack = new Stack<List<Integer>>();
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(root == null) {
    		return list;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
        	int count = queue.size();
        	List<Integer> row = new ArrayList<Integer>();
        	while(count > 0) {
        		TreeNode node = queue.poll();
        		row.add(node.val);
        		if(node.left != null) {
        			queue.offer(node.left);
        		}
        		if(node.right != null) {
        			queue.offer(node.right);
        		}
        		count--;
        	}
        	stack.push(row);
    	}
    	while(!stack.isEmpty()) {
    		List<Integer> row = stack.pop();
    		list.add(row);
    	}
    	return list;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools.printArray2(LevelOrder102And107.levelOrderBottom(Tools.arrayToTree(new Object[] {3,1,null,2,7,null,9})));
		Tools.printArray2(LevelOrder102And107.levelOrder(Tools.arrayToTree(new Object[] {3,1,null,2,7,null,9})));
	}

}
