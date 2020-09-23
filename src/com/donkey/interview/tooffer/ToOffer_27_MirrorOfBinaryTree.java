package com.donkey.interview.tooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 刻苦驴
 * @Date 2020.09.16
 * @Time 18:17
 * @Package PACKAGE_NAME
 * @Description 面试题27-二叉树的镜像
 */

public class ToOffer_27_MirrorOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode tmp = root.left;
//        root.left = mirrorTree(root.right);
//        root.right = mirrorTree(tmp);
//        return root;
//    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            tmp = cur.right;
            cur.right = cur.left;
            cur.left = tmp;
        }
        return root;
    }
}
