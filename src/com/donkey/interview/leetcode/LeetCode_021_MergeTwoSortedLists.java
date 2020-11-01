package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-021-合并两个有序链表
 * @since 2020.11.01 21:24
 */

public class LeetCode_021_MergeTwoSortedLists {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 定义一个节点
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        // 当两个链表节点都不为空时
        while (l1 != null && l2 != null) {
            // 找出较小的一个节点, 拼接到cur
            if (l1.val <= l2.val) {
                cur.next = l1;
                // 迭代
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            // 迭代
            cur = cur.next;
        }
        // 将剩余节点拼上
        cur.next = l1 != null ? l1 : l2;
        // head的下一个节点才是我们要的新链表的头节点
        return head.next;
    }
}
