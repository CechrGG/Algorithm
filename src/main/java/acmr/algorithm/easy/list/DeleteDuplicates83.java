/**
 * 
 */
package acmr.algorithm.easy.list;

import java.util.HashMap;
import java.util.Map;

import acmr.algorithm.common.ListNode;

/**
 * @author guohz
 * @date 2020年9月8日
 * @description DeleteDuplicates83
 * 
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

	示例 1:
	输入: 1->1->2
	输出: 1->2
	
	示例 2:
	输入: 1->1->2->3->3
	输出: 1->2->3
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates83 {
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		while(p != null && p.next != null) {
			if(p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return head;
    } 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
