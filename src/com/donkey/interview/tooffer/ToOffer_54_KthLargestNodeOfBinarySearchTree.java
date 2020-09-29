package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题54-二叉搜索树的第K大节点
 * @since 2020.09.29 16:25
 */

public class ToOffer_54_KthLargestNodeOfBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int count = 0;
    int result = 0;

    public int kthLargest(TreeNode root, int k) {
        depthTravel(root, k);
        return result;
    }

    public void depthTravel(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        depthTravel(root.right, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        depthTravel(root.left, k);
    }
}
