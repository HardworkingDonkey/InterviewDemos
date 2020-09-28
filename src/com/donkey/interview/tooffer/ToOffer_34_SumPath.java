package com.donkey.interview.tooffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题34-二叉树中和为某一值的路径
 * @since 2020.09.25 14:09
 */

public class ToOffer_34_SumPath {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 使用LinkedList效率比ArrayList高
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        path(root, sum);
        return result;
    }

    public void path(TreeNode root, int tmp) {
        if (root == null) {
            return;
        }
        tmp -= root.val;
        stack.add(root.val);
        // 如果是叶子节点
        if (tmp == 0 && root.left == null && root.right == null) {
            // 注意, 记录路径时若直接执行 res.add(path)则是将 path 对象加入了 res
            // 后续 path 改变时, res 中的 path 对象也会随之改变
            // 正确做法: res.append(new ArrayList<>(path)), 相当于复制了一个 path 并加入到 res
            result.add(new LinkedList<>(stack));
        }
        path(root.left,  tmp);
        path(root.right, tmp);
        stack.removeLast();
    }
}
