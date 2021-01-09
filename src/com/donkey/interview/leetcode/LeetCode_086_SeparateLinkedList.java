package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-086-分隔链表
 * @since 2021.01.08 17:13
 */

public class LeetCode_086_SeparateLinkedList {
    public class ListNode {
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

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(-1);
        ListNode large = largeHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

//    public ListNode partition(ListNode head, int x) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode cur = dummy;
//        // 找出第一个比x大的节点的上一个节点
//        while (cur.next != null && cur.next.val < x) {
//            cur = cur.next;
//        }
//        if (cur.next == null) {
//            return head;
//        } else { // 此时cur指向第一个比大于等于x的节点的上一个节点
//            ListNode nodeToFollow = cur;
//            while (cur.next != null) {
//                if (cur.next.val < x) {
//                    ListNode temp = cur.next;
//                    cur.next = cur.next.next;
//                    temp.next = nodeToFollow.next;
//                    nodeToFollow.next = temp;
//                }
//                cur = cur.next;
//            }
//            return dummy.next;
//        }
//    }
}
