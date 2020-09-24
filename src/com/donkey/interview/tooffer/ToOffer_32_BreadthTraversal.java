package com.donkey.interview.tooffer;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题32-从上到下打印二叉树
 * @since 2020.09.24 19:03
 */

public class ToOffer_32_BreadthTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 普通广度遍历
//    public int[] levelOrder(TreeNode root) {
//        if (root == null) {
//            return new int[0];
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<Integer> travel = new ArrayList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.remove();
//            travel.add(cur.val);
//            if (cur.left != null) {
//                queue.add(cur.left);
//            }
//            if (cur.right != null) {
//                queue.add(cur.right);
//            }
//        }
//        int[] result = new int[travel.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = travel.get(i);
//        }
//        return result;
//    }

    // 每一层一个独立List
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> travel = new ArrayList<>();
//        if (root != null) {
//            queue.add(root);
//        }
//        while (!queue.isEmpty()) {
//            List<Integer> tmp = new LinkedList<>();
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode cur = queue.remove();
//                tmp.add(cur.val);
//                if (cur.left != null) {
//                    queue.add(cur.left);
//                }
//                if (cur.right != null) {
//                    queue.add(cur.right);
//                }
//            }
//            travel.add(tmp);
//        }
//        return travel;
//    }

    // "之"字形打印二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> travel = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                // 0, 2, 4...时正序
                if ((travel.size() & 0x1) == 0) {
                    tmp.addLast(cur.val);
                } else { // 1, 3, 5...时逆序
                    tmp.addFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            travel.add(tmp);
        }
        return travel;
    }
}
