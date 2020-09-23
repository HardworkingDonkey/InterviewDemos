package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题28-对称的二叉树
 * @since 2020.09.23 17:48
 */

public class ToOffer_28_SymmetricBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode a, TreeNode b) {
        // 两个节点都为空时无法判断, 返回真(最终结果是"与", 所以返回真不影响)
        if (a == null && b == null) {
            return true;
        }
        // 至少一个不为空
        // 当有一个为空时, 返回false
        if (a == null || b == null) {
            return false;
        }
        // 节点值不相等时返回false
        if (a.val != b.val) {
            return false;
        }
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
