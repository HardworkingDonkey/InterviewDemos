package com.donkey.interview.tooffer;

import java.util.LinkedList;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题37-序列化二叉树
 * @since 2020.09.27 21:50
 */

public class ToOffer_37_BinaryTreeCodec {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 利用队列 + 广度遍历
    // 扫描队列节点, 如果不为空, 拼接值到字符串, 否则拼接null
    // 然后将节点的左右子节点加入队列
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            // 节点不为空时拼接值, 并把左右子节点加入队列
            if (cur != null) {
                result.append(cur.val).append(",");
                nodes.addLast(cur.left);
                nodes.addLast(cur.right);
            } else { // 否则拼接null
                result.append("null,");
            }
        }
        // 把最后的","去掉并拼接"]"
        return result.deleteCharAt(result.length() - 1).append("]").toString();
    }


    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        // 先把左右括号去掉, 以","分割
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        // 取出第一个字符串生成节点
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        // 借助队列, 类似于广度遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int i = 1; // 遍历字符串数组的索引
        while (i < nodes.length && !queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            // 如果取出字符串不是"null"
            if (!"null".equals(nodes[i])) {
                // 添加到左子树
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                // 添加到队列
                queue.addLast(cur.left);
            }
            // 无论是不是null都要移动索引
            i++;
            if (i < nodes.length && !"null".equals(nodes[i])) {
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.addLast(cur.right);
            }
            i++;
        }
        return root;
    }
}
