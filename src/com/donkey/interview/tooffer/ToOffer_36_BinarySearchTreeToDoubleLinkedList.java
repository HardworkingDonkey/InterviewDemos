package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题36-二叉搜索树与双向链表
 * @since 2020.09.27 18:50
 */

public class ToOffer_36_BinarySearchTreeToDoubleLinkedList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node prev = null;
    Node head = null;
    Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 中序遍历二叉树
        inorder(root);
        // 头节点和尾节点需要互指
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        // 如果node是第一个节点
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
        }
        node.left = prev;
        prev = node;
        tail = node;
        inorder(node.right);
    }
}
