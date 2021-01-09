package com.donkey.interview.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-082-删除排序链表中的重复元素
 * @since 2020.12.21 11:30
 */

public class LeetCode_082_DeleteDuplicates {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 7%, 85%
//    public ListNode deleteDuplicates(ListNode head) {
//        Map<Integer, Integer> count = new LinkedHashMap<>();
//        ListNode cur = head;
//        while (cur != null) {
//            if (!count.containsKey(cur.val)) {
//                count.put(cur.val, 1);
//            } else {
//                count.put(cur.val, count.get(cur.val) + 1);
//            }
//            cur = cur.next;
//        }
//        cur = head;
//        head = null;
//        ListNode newCur = null;
//        while (cur != null) {
//            if (count.get(cur.val) == 1) {
//                if (head == null) {
//                    head = new ListNode(cur.val);
//                    newCur = head;
//                } else {
//                    newCur.next = new ListNode(cur.val);
//                    newCur = newCur.next;
//                }
//            }
//            cur = cur.next;
//        }
//        return head;
//    }

    // 100%, 95%
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
            // 当前节点与下一个节点相等
        } else if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
            // 当前节点与下一个节点不等
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
