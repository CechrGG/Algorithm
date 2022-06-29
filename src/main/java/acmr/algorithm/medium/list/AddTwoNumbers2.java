package acmr.algorithm.medium.list;

import acmr.algorithm.common.ListNode;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/6/29
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * 通过次数1,389,088提交次数3,316,187
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        int val = l1.val + l2.val;
        ListNode next = null;
        if(val >= 10) {
            sum.val = val - 10;
            next = new ListNode();
            next.val = 1;
        } else {
            sum.val = val;
            if(l1.next != null || l2.next != null) {
                next = new ListNode();
                next.val = 0;
            }
        }
        sum.next = next;
        if(sum.next != null) {
            while (l1.next != null) {
                l1 = l1.next;
                ListNode nx = null;
                if (l2.next != null) {
                    l2 = l2.next;
                    int valNext = l1.val + l2.val + next.val;
                    if(valNext >= 10) {
                        next.val = valNext - 10;
                        nx = new ListNode();
                        nx.val = 1;
                    } else {
                        next.val = valNext;
                        if(l1.next != null || l2.next != null) {
                            nx = new ListNode();
                            nx.val = 0;
                        }
                    }
                } else {
                    int valNext = l1.val + next.val;
                    if(valNext >= 10) {
                        next.val = valNext - 10;
                        nx = new ListNode();
                        nx.val = 1;
                    } else {
                        next.val = valNext;
                        if(l1.next != null) {
                            nx = new ListNode();
                            nx.val = 0;
                        }
                    }
                }

                next.next = nx;
                next = nx;
            }
            while (l2.next != null) {
                l2 = l2.next;
                ListNode nx = null;
                int valNext = l2.val + next.val;
                if(valNext >= 10) {
                    next.val = valNext - 10;
                    nx = new ListNode();
                    nx.val = 1;
                } else {
                    next.val = valNext;
                    if(l2.next != null) {
                        nx = new ListNode();
                        nx.val = 0;
                    }
                }
                next.next = nx;
                next = nx;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
//        ListNode l1 = new ListNode(0, null);
//        ListNode l2 = new ListNode(0, null);
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        System.out.println(addTwoNumbers(l1, l2));
    }
}
