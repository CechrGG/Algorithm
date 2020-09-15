/**
 * 
 */
package acmr.algorithm.util;

import java.util.LinkedList;
import java.util.Queue;

import acmr.algorithm.common.TreeNode;

/**
 * @author guohz
 * @date 2020年8月19日
 * @description Tools
 */
public class Tools {
	
	/**
	 * 将数据组对象转化为“，”相隔的字符串
	 * @param ret
	 * @return 
	 */
	public static String arrayToString(int[] ret) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ret.length - 1; i++) {
			sb.append(ret[i] + ",");
		}
		sb.append(ret[ret.length - 1]);
		return sb.toString();
	}
	
	/**
	 * 将中序数组转化为二叉树
	 */
	public static TreeNode arrayToTree(Object[] arr) {
		if(arr == null || arr.length <= 0) {
			return null;
		}
		TreeNode root = null, temp = null;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && root == null) {
				root = new TreeNode((int)arr[i]);
				temp = root;
				queue.offer(temp);
			}
			if(!queue.isEmpty()) {
				temp = queue.poll();
			} else {
				break;
			}
			if(i + 1 < arr.length && arr[i+1] != null) {
				temp.left = new TreeNode((int)arr[i+1]);
				queue.offer(temp.left);
			}
			if(i + 2 < arr.length && arr[i+2] != null) {
				temp.right = new TreeNode((int)arr[i+2]);
				queue.offer(temp.right);
			}
			i++;
 		}
		return root;
	}

	
	/**
	 * 中序打印二叉树
	 * @param tree
	 */
	public static void printMidTree(TreeNode tree) {
		if(tree == null) {
//			System.out.print("null,");
			return;
		} else {
			printMidTree(tree.left);
			System.out.print(tree.val + ",");
			printMidTree(tree.right);
		}
	}
	
	/**
	 * 前序打印二叉树
	 * @param tree
	 */
	public static void printPreTree(TreeNode tree) {
		if(tree == null) {
//			System.out.print("null,");
			return;
		} else {
			System.out.print(tree.val + ",");
			printPreTree(tree.left);
			printPreTree(tree.right);
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] arr = new Object[] {1,null,3,null,4,5,6,7};
		TreeNode tree = arrayToTree(arr);
		printMidTree(tree);
	}

}
