/**
 * 
 */
package acmr.algorithm.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

import acmr.algorithm.common.TreeNode;

/**
 * @author guoguo
 * @date 2020年9月12日
 * @Description SymmetricTree101
 * 
 * 	给定一个二叉树，检查它是否是镜像对称的。

	例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	 
	
	但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	
	    1
	   / \
	  2   2
	   \   \
	   3    3
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/symmetric-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricTree101 {
	
	//哈哈，他么的改变了树的结构可还行
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
        	return true;
        } else if(root.left == null && root.right == null) {
        	return true;
        } else if(root.left == null || root.right == null) {
        	return false;
        } else if(root.left.val != root.right.val) {
        	return false;
        } else {
        	TreeNode left = root.left;
        	TreeNode right = root.right;
        	TreeNode leftRight = left.right;
        	left.right = right.right;
        	right.right = leftRight;
        	return isSymmetric(left) && isSymmetric(right);
        }
    }
    
    //深入
    public boolean isSymmetric2(TreeNode node) {
    	return check(node, node);
    }
    
    public boolean check(TreeNode left, TreeNode right) {
    	if(left == null && right == null) {
    		return true;
    	}
    	if(left == null || right == null) {
    		return false;
    	}
    	return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
    
    //遍历
    public boolean checkQueue(TreeNode left, TreeNode right) {
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(left);
    	queue.offer(right);
    	while(!queue.isEmpty()) {
    		TreeNode node1 = queue.poll();
    		TreeNode node2 = queue.poll();
    		if(node1 == null && node2 == null) {
    			continue;
    		}
    		if((node1 == null || node2 == null) || node1.val != node2.val) {
    			return false;
    		}
    		queue.offer(left.left);
    		queue.offer(right.right);
    		queue.offer(left.right);
    		queue.offer(right.left);
    	}
    	return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
