package com.donkey.interview.tooffer;

import java.util.HashMap;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题35-复杂链表的复制
 * @since 2020.09.27 18:26
 */

public class ToOffer_35_CopyComplexLinkedList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 用HashMap保存<当前节点, 复制的当前节点>
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 遍历原有链表, 复制所有节点, 通过HashMap建立源节点和复制后的节点的联系
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 然后再次遍历原链表, 将原来节点的next和random的关系也复制给新节点
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
