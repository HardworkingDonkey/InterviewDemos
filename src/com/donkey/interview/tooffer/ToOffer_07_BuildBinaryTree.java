package com.donkey.interview.tooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 刻苦驴
 * @Date 2020.09.09
 * @Time 21:09
 * @Package PACKAGE_NAME
 * @Description 面试题7-重建二叉树
 */

public class ToOffer_07_BuildBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        // 用于保存中序遍历数组的<元素, 索引>
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        // 将中序数组中的<值, 索引>存入map
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        // 前序遍历的第一个元素就是当前子树的根节点
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            // 获取中序遍历中根节点的索引
            int rootIndex = indexMap.get(rootVal);
            // 算出新一轮左右子树节点个数
            int leftLength = rootIndex - inorderStart;
            int rightLength = inorderEnd - rootIndex;
            // 通过缩小前序遍历和中序遍历数组的范围, 来达到逐层确定子树
            root.left = buildTree(preorder, preorderStart + 1, preorderStart + leftLength, inorder, inorderStart, rootIndex - 1, indexMap);
            root.right = buildTree(preorder, preorderEnd - rightLength + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            return root;
        }
    }
}