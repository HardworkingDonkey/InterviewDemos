package com.donkey.interview.tooffer;

import java.util.Stack;

/**
 * @Author 刻苦驴
 * @Date 2020.09.09
 * @Time 20:37
 * @Package PACKAGE_NAME
 * @Description 面试题6-逆序打印链表
 */

public class ToOffer_06_ReversePrintLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }
}