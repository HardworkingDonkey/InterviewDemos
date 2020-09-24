package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题33-二叉搜索树的后序遍历序列
 * @since 2020.09.24 23:44
 */

public class ToOffer_33_PostfixSequence {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0 , postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        // 当前子树只剩一个节点
        if (start >= end) {
            return true;
        }
        // i索引用来划出左子树的范围
        int i = start;
        // 当遍历到第一个比根节点大的就停下
        while (postorder[i] < postorder[end]) {
            i++;
        }
        // j索引用来划出右子树的范围(从左子树往右)
        int j = i;
        // 理想情况下遇到根节点才停下
        while (postorder[j] > postorder[end]) {
            j++;
        }
        // 所以当 j == end 时当前根节点暂时满足后序遍历, 然后递归判断左右子树是否满足后序遍历
        return j == end && verifyPostorder(postorder, start, i - 1) && verifyPostorder(postorder, i, end - 1);

    }
}
