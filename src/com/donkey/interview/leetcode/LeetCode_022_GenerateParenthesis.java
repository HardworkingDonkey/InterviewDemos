package com.donkey.interview.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-022-括号生成
 * @since 2020.11.01 22:36
 */

public class LeetCode_022_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        if (n > 0) {
            // 深度优先遍历
            dfs("", n, n, result);
        }
        return result;
    }

    /**
     * 深度优先遍历: 生成括号
     * 当前左右括号都有大于 0 个可以使用的时候，才产生分支
     * 产生左分支时, 只看当前是否还有左括号可以使用
     * 产生右分支时, 右边剩余可以使用的括号数量一定得大于左边剩余的数量, 才可以产生分支
     * 在左边和右边剩余的括号数都等于 0 的时候将缓存字符串加入结果
     *
     * @param buffer 缓存字符串
     * @param left   剩余左括号数
     * @param right  剩余右括号数
     * @param result 答案结果集
     * @return void
     */
    private void dfs(String buffer, int left, int right, LinkedList<String> result) {
        // 如果左右括号刚好用完, 添加结果
        if (left == 0 && right == 0) {
            result.add(buffer);
        }
        // 如果剩余右括号 < 左括号, 非法, 直接返回
        if (right < left) {
            return;
        }
        // 如果还剩有左括号
        if (left > 0) {
            dfs(buffer + "(", left - 1, right, result);
        }
        // 如果还剩有右括号
        if (right > 0) {
            dfs(buffer + ")", left, right - 1, result);
        }
    }
}
