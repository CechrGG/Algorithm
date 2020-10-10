/**
 * 
 */
package acmr.algorithm.easy.list;

import java.util.HashSet;

import acmr.algorithm.common.ListNode;

/**
 * @author guohz
 * @date 2020年10月10日
 * @description IntersectionNode160
 */
public class IntersectionNode160 {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(headA != null) {
        	set.add(headA);
        	headA = headA.next;
        }
        while(headB != null) {
        	if(set.contains(headB)) {
        		return headB;
        	} else {
        		headB = headB.next;
        	}
        }
        return null;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
