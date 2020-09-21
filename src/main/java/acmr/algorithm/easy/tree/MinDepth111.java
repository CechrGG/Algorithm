/**
 * 
 */
package acmr.algorithm.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

import acmr.algorithm.common.TreeNode;
import acmr.algorithm.util.Tools;

/**
 * @author guohz
 * @date 2020年9月21日
 * @description MinDepth111
 * 
 * 	给定一个二叉树，找出其最小深度。

	最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
	
	说明: 叶子节点是指没有子节点的节点。
	
	示例:
	
	给定二叉树 [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回它的最小深度  2.
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDepth111 {
	
	//深度优先
    public static int minDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.left == null) {
    		return 1 + minDepth(root.right);
    	}
    	if(root.right == null) {
    		return 1 + minDepth(root.left);
    	}
    	return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    
    //广度优先,相对更好一点，只要找到最短路径就返回了，无需过多计算
    public static int minDepth2(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int min = 0;
    	while(!queue.isEmpty()) {
    		min++;
    		int size = queue.size();
    		for(int i = 0; i < size; i++) {
	    		TreeNode node = queue.poll();
	    		if(node.left == null && node.right == null) {
	    			queue.clear();
	    			break;
	    		}
	    		if(node.left != null) {
	    			queue.offer(node.left);
	    		}
	    		if(node.right != null) {
	    			queue.offer(node.right);
	    		}
    		}
    	}
    	return min;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MinDepth111.minDepth(Tools.arrayToTree(new Object[] {3,9,20,null,null,15,7})));
		System.out.println(MinDepth111.minDepth2(Tools.arrayToTree(new Object[] {3,9,20,null,null,15,7})));
		System.out.println(MinDepth111.minDepth(Tools.arrayToTree(new Object[] {1,2})));
		System.out.println(MinDepth111.minDepth2(Tools.arrayToTree(new Object[] {1,2})));
	}

}
