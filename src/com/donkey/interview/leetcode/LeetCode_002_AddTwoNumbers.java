package com.donkey.interview.leetcode;

/**
 * @Author 刻苦驴
 * @Date 2020.05.04
 * @Time 11:30
 * @Package PACKAGE_NAME
 * @Description LeetCode(2)-两数相加
 */

public class LeetCode_002_AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10; // 进位
            node.next = new ListNode(sum % 10); // 本位和
            node = node.next;
            l1 = l1 != null ? l1.next : l1; // 防止空指针
            l2 = l2 != null ? l2.next : l2; // 防止空指针
        }
        return result.next;
    }
}
