package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.16
 * @Time 17:37
 * @Package PACKAGE_NAME
 * @Description 面试题22-链表中倒数第k个节点
 */

public class ToOffer_22_GetFromEndOfLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode cur = head;
        // 算出长度
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        // k大于长度, 不合理
        if (k > length) {
            return null;
        }
        // 定义两个指针
        cur = head;
        ListNode behind = head;
        // 让其中一个指针先走k - 1步
        for (int i = 0; i < k - 1; i++) {
            behind = behind.next;
        }
        // 此后两个指针同时走, 当后面的指针走到尾节点时, 前面的指针刚好是倒数第k个节点
        while (behind.next != null) {
            behind = behind.next;
            cur = cur.next;
        }
        return cur;
    }
}
