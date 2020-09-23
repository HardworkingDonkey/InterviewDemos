package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.16
 * @Time 13:54
 * @Package PACKAGE_NAME
 * @Description 面试题18-删除链表的节点
 */

public class ToOffer_18_DeleteNodeInLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 如果要删除的节点刚好是头结点
        if (head.val == val) {
            // 并且只有一个节点, 直接返回空链表
            if (head.next == null) {
                return null;
            }
            // 如果还有后继, 则直接返回后继作为新头节点
            else {
                return head.next;
            }
        }
        ListNode cur = head;
        // 循环遍历直到找到要删除的节点的前一个节点
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        // 跳出循环后如果当前节点的next为空, 说明链表中没有要删除的节点
        if (cur.next == null) {
            return null;
        }
        // 不为空则说明找到了节点, 所以提前跳出了循环
        else {
            // 如果要删除的节点不为尾节点, 则将当前节点的next赋值为要删除的节点的next
            if (cur.next.next != null) {
                cur.next = cur.next.next;
            }
            // 否则则是要删除尾节点, 则当前节点的next置空
            else {
                cur.next = null;
            }
        }
        return head;
    }
}
