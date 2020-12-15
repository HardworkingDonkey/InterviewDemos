package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-061-旋转链表
 * @since 2020.12.11 22:10
 */

public class LeetCode_061_RotateLinkedList {
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

    // 100%, 60%
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode tail; // 优化: 提前找出尾节点
        // 求出链表长度
        int length = 1;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        tail = cur; // 记录尾节点
        k %= length; // 原先用while去减去length, 傻逼
        if (k == 0) {
            return head; // k=0直接返回
        }
        ListNode newHead; // 新头节点
        cur = head;
        // 循环找出新的头节点的上一个节点
        for (int i = 0; i < length - k - 1; i++) {
            cur = cur.next;
        }
        newHead = cur.next; // 新头节点
        cur.next = null; // 断开
        tail.next = head; // 尾节点连上原来的头节点
        return newHead;
    }

    // 官方题解
//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null) return null;
//        if (head.next == null) return head;
//        // 让链表变成环
//        ListNode old_tail = head;
//        int n;
//        for (n = 1; old_tail.next != null; n++)
//            old_tail = old_tail.next;
//        old_tail.next = head;
//
//        // find new tail : (n - k % n - 1)th node
//        // and new head : (n - k % n)th node
//        ListNode new_tail = head;
//        for (int i = 0; i < n - k % n - 1; i++)
//            new_tail = new_tail.next;
//        ListNode new_head = new_tail.next;
//
//        // break the ring
//        new_tail.next = null;
//
//        return new_head;
//    }
}
