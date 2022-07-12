package acmr.algorithm.medium.list;

import acmr.algorithm.common.ListNode;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/7/12
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveEndNode19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode pTmp = head;
        while (pTmp != null) {
            count++;
            pTmp = pTmp.next;
        }
        int target = count - n;
        if(target == 0 ) {
            if(count == 1) {
                return null;
            } else {
                head = head.next;
                return head;
            }
        } else {
            pTmp = head;
            for(int i = 0; i < target - 1; i++) {
                pTmp = pTmp.next;
            }
            pTmp.next = pTmp.next.next;
            return head;
        }
    }

    /**
     * 快慢指针，妙啊
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        System.out.println(removeNthFromEnd(listNode, 4));
//        System.out.println(removeNthFromEnd(listNode, 1));
        System.out.println(removeNthFromEnd(listNode, 5));
    }
}
