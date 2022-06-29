/**
 * 
 */
package acmr.algorithm.common;

/**
 * @author guohz
 * @date 2020年9月8日
 * @description ListNode
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode() {}
	public ListNode(int val) { this.val = val; }
	public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	public ListNode next() {
		return next;
	}
	public void setNext(ListNode node) {
		this.next = node;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ListNode->" + val);
		while (next != null) {
			sb.append("->").append(next.val);
			next = next.next;
		}
		return sb.toString();
	}
}
