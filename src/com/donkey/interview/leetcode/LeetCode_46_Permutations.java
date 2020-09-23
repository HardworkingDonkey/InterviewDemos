package com.donkey.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-46-全排列
 * @since 2020.09.21 19:09
 */

public class LeetCode_46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 存储中间结果
        Deque<Integer> tmp = new ArrayDeque<>();
        // 标记数组中的所有数字有无被使用
        boolean[] used = new boolean[len];
        // 回溯算法(数组, 长度, 深度, 中间结果, 标记数组, 结果集合)
        dfs(nums, len, 0, tmp, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> tmp, boolean[] used, List<List<Integer>> res) {
        // 如果深度 == 长度, 说明排列已经到了最后一位, 可以加入结果集
        if (depth == len) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        // 遍历数组, 每个数字都有可能要被遍历
        for (int i = 0; i < len; i++) {
            // 如果当前数没被使用
            if (!used[i]) {
                // 加到中间结果
                tmp.addLast(nums[i]);
                // 并设置为已遍历
                used[i] = true;
                // 递归, 深度 + 1
                dfs(nums, len, depth + 1, tmp, used, res);
                // 回溯后, 设置为未遍历以及移出
                used[i] = false;
                tmp.removeLast();
            }
        }
    }
}
