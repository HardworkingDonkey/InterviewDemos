package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-025-K个一组翻转链表
 * @since 2020.11.14 9:45
 */

public class LeetCode_025_ReverseKGroupsInLinkedList {
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

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        // 定义一个假的节点
//        ListNode dummy = new ListNode(0);
//        // 假节点的next指向head
//        // dummy -> 1 -> 2 -> 3 -> 4 -> 5
//        dummy.next = head;
//        // 初始化pre和end都指向dummy
//        // pre指每次要翻转的链表的头结点的上一个节点
//        // end指每次要翻转的链表的尾节点
//        ListNode pre = dummy;
//        ListNode end = dummy;
//        while (end.next != null) {
//            // 循环k次，找到需要翻转的链表的结尾
//            // 这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常
//            // dummy->1->2->3->4->5 若k为2，循环2次，end指向2
//            for (int i = 0; i < k && end != null; i++) {
//                end = end.next;
//            }
//            // 如果 end == null 即需要翻转的链表的节点数小于k，不执行翻转
//            if (end == null) {
//                break;
//            }
//            // 先记录下end.next,方便后面链接链表
//            ListNode next = end.next;
//            // 然后断开链表
//            end.next = null;
//            // 记录下要翻转链表的头节点
//            ListNode start = pre.next;
//            // 翻转链表,pre.next指向翻转后的链表。1->2 变成2->1  dummy->2->1
//            pre.next = reverse(start);
//            // 翻转后头节点变到最后。通过.next把断开的链表重新链接。
//            start.next = next;
//            // 将pre换成下次要翻转的链表的头结点的上一个节点。即start
//            pre = start;
//            // 翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
//            end = start;
//        }
//        return dummy.next;
//    }

//    //链表翻转
//    // 例子：   head： 1->2->3->4
//    public ListNode reverse(ListNode head) {
//        //单链表为空或只有一个节点，直接返回原单链表
//        if (head == null || head.next == null) {
//            return head;
//        }
//        //前一个节点指针
//        ListNode preNode = null;
//        //当前节点指针
//        ListNode curNode = head;
//        //下一个节点指针
//        ListNode nextNode;
//        while (curNode != null) {
//            nextNode = curNode.next;//nextNode 指向下一个节点,保存当前节点后面的链表。
//            curNode.next = preNode;//将当前节点next域指向前一个节点   null<-1<-2<-3<-4
//            preNode = curNode;//preNode 指针向后移动。preNode指向当前节点。
//            curNode = nextNode;//curNode指针向后移动。下一个节点变成当前节点
//        }
//        return preNode;
//    }

    // 链表翻转 head: 1->2->3->4
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next; // next 指向下一个节点, 保存当前节点后面的链表
            cur.next = pre; // 将当前节点 next 指向前一个节点   null<-1<-2<-3<-4
            pre = cur; // pre 指针向后移动, pre 指向当前节点
            cur = next; // cur 指针向后移动, cur指向下一个节点
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义辅助节点保存最终头节点的上一个节点
        ListNode temp = new ListNode();
        // pre指向每次要交换的那段链表的前一个节点
        ListNode pre = temp;
        // 注意将pre指向头节点
        pre.next = head;
        // start指向每次要交换的那段链表的第一个节点
        ListNode start = pre;
        // end指向每次要交换的那段链表的尾节点
        ListNode end = start;
        // next指向每次要交换的那段链表的后继节点
        ListNode next;
        while (end.next != null) {
            // 通过循环找到要翻转的那段链表的最后节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 注意: 遍历的时候如果end为null, 则说明剩余链表不足k个
            if (end == null) {
                break;
            }
            // 记录要翻转的那段链表的尾节点的下一个节点
            next = end.next;
            // 断开链表
            end.next = null;
            // start指向前驱节点的下一个
            start = pre.next;
            // 反转
            // 前驱的next指向反转后的那段链表的头
            pre.next = reverse(start);
            // 翻转后的start变为"翻转的那段链表"的尾节点, 将其next指向原来保存的next
            start.next = next;
            // 更新end, 下一轮要继续寻找下一段链表的尾节点
            end = start;
            // 此时的start也刚好是下一段要翻转的链表的前驱节点
            pre = start;
        }
        return temp.next;
    }
}
