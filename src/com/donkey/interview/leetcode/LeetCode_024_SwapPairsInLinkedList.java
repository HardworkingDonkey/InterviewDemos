package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-024-两两交换链表中的节点
 * @since 2020.11.13 10:58
 */

public class LeetCode_024_SwapPairsInLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode left = cur.next;
            ListNode right = cur.next.next;
            left.next = right.next;
            cur.next = right;
            right.next = left;
            cur = left;
        }
        return pre.next;
    }

}
