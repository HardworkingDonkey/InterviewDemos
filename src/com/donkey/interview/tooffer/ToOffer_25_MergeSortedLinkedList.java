package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题25-合并两个排序的链表
 * @since 2020.09.22 14:41
 */

public class ToOffer_25_MergeSortedLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        ListNode newHead;
        if (l1.val < l2.val) {
            newHead = l1;
            newHead.next = mergeTwoLists(l1.next, l2);
        } else {
            newHead = l2;
            newHead.next = mergeTwoLists(l1, l2.next);
        }
        return newHead;
    }
}
