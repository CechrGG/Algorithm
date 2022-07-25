package acmr.algorithm.medium.list;

import acmr.algorithm.common.ListNode;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/25
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *  
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseNodes25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode ret = new ListNode(0, new ListNode());
        ListNode retP = ret.next;
        ListNode p = head;
        int count = 1;
        while (p != null) {
            if(count == k) {
                ListNode tmp = p.next;
                p.next = null;
                retP.next = reversList(head);
                for(int i = 0; i < k; i++) {
                    retP = retP.next;
                }
                head = tmp;
                p = head;
                count = 1;
            } else {
                p = p.next;
                count++;
            }
        }
        retP.next = head != null ? head : null;
        return ret.next.next;
    }

    public static ListNode reversList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode ret = new ListNode();
        while (head != null) {
            ListNode tmp = head.next;
            head.next = ret.next;
            ret.next = head;
            head = tmp;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        System.out.println(reversList(list));
        System.out.println(reverseKGroup(list, 6));
    }
}
