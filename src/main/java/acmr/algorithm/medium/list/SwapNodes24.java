package acmr.algorithm.medium.list;

import acmr.algorithm.common.ListNode;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/21
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNodes24 {

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode hpre = new ListNode();
        ListNode tail = hpre, p1 = head, p2 = head.next;
        while (p1 != null && p2 != null) {
            ListNode tmp1 = p2.next;
            ListNode tmp2 = tmp1 == null ? null : tmp1.next;
            p1.next = null;
            p2.next = null;
            tail.next = p2;
            tail.next.next = p1;
            tail = tail.next.next;
            p1 = tmp1;
            p2 = tmp2;
        }
        tail.next = p1;
        return hpre.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(head);
        System.out.println(swapPairs(head));
    }
}
