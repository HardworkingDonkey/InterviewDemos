package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.14
 * @Time 19:14
 * @Package PACKAGE_NAME
 * @Description 面试题8-二叉树的下一个节点(中序遍历: 左根右)
 */

public class ToOffer_08_NextNodeOfInorder {
    static class Node {
        Node parent;
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getNextOfInorder(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        // 如果当前节点有右子树, 则下一节点为右子树的最左的节点
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 如果当前节点没有右子树
        // 并且父节点为空, 则该节点为最后一个节点
        if (cur.parent == null) {
            return null;
        }
        // 如果当前节点没有右子树
        // 则需要往上找到第一个是它父节点的左子节点的节点, 返回父节点
        while (cur.parent != null && cur != cur.parent.left) {
            cur = cur.parent;
        }
        return cur.parent;
    }
}