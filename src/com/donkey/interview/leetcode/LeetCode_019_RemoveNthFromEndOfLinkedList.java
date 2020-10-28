package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-019-删除链表的倒数第N个节点
 * @since 2020.10.28 17:07
 */

public class LeetCode_019_RemoveNthFromEndOfLinkedList {
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

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null) {
//            return null;
//        }
//        ListNode ahead = head;
//        // 先走的指针往后走 n - 1 步
//        for (int i = 0; i < n - 1; i++) {
//            ahead = ahead.next;
//        }
//        // 如果ahead已经是最后一个节点, 则说明要删除的是头节点
//        if (ahead.next == null) {
//            return head.next;
//        }
//        // 然后两个指针一起走, 先走的指针到尾部时, 后走的指针就指向要找的节点
//        // 注意保留好要删除节点的上一个节点
//        ListNode pre = head;
//        ListNode cur = head.next;
//        ahead = ahead.next;
//        // 让先走的指针走到最后
//        while (ahead.next != null) {
//            ahead = ahead.next;
//            cur = cur.next;
//            pre = pre.next;
//        }
//        // 如果要删除最后一个节点
//        if (cur.next == null) {
//            pre.next = null;
//        } else {
//            pre.next = cur.next;
//        }
//        return head;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode ahead = head;
        // 先走的指针往后走 n 步
        for (int i = 0; i < n; i++) {
            ahead = ahead.next;
        }
        // 如果ahead已经是最后一个节点, 则说明要删除的是头节点
        if (ahead == null) {
            return head.next;
        }
        // 然后两个指针一起走, 先走的指针到尾部时, 后走的指针就指向要删除的节点的上一个节点
        // pre是要删除节点的上一个节点
        ListNode pre = head;
        // 让先走的指针走到最后
        while (ahead.next != null) {
            ahead = ahead.next;
            pre = pre.next;
        }
        // 删除指定节点
        pre.next = pre.next.next;
        return head;
    }
}
