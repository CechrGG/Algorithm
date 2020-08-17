/**
 * 
 */
package acmr.algorithm.easy;

/**
 * @author guoguo
 * @date 2020年8月14日
 * @Description MergeLists
 * 
 * 	将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
	示例：
	
	输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeLists {
	
	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) {
    		return l2;
    	} else if(l2 == null) {
    		return l1;
    	}

    	if(l1.val <= l2.val) {
    		l1.next = mergeTwoLists(l1.next, l2);;
    		return l1;
    	} else {
    		l2.next = mergeTwoLists(l1, l2.next);
    		return l2;
    	}
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeLists ml = new MergeLists();
		ListNode l1 = new ListNode(1);
//		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode mtl = ml.mergeTwoLists(l1, l2);
		while(mtl.next != null) {
			System.out.print(mtl.val + "->");
			mtl = mtl.next;
		}
		System.out.print(mtl.val);
		
	}

}
