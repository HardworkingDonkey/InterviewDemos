package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题24-反转链表
 * @since 2020.09.22 13:55
 */

public class ToOffer_24_ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 如果只有一个节点
        if (head.next == null) {
            return head;
        }
        // 四个变量: 新的头结点, 当前节点, 上一个节点, 下一个节点
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            // 判断下一个节点是否为空, 空则说明cur已经是尾结点
            if (next == null) {
                newHead = cur;
            }
            // 将当前节点的next指向上一个节点(如果是头节点则指向空)
            cur.next = prev;
            // 上一个节点赋值为当前
            prev = cur;
            // 当前节点赋值为下一个节点
            cur = next;
        }
        return newHead;
    }
}
