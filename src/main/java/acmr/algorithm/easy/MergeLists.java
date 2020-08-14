/**
 * 
 */
package acmr.algorithm.easy;

/**
 * @author guoguo
 * @date 2020年8月14日
 * @Description MergeLists
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
