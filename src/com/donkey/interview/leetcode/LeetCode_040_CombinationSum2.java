package com.donkey.interview.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-040-组合总和II
 * @since 2020.12.02 8:21
 */

public class LeetCode_040_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();
        dfs(candidates, 0, target, result, path);
        return result;
    }

    private void dfs(int[] candidates, int begin, int target, List<List<Integer>> result, Deque<Integer> path) {
        if (target == 0) {
            result.add(new LinkedList<>(path));
        } else {
            for (int i = begin; i < candidates.length; i++) {
                int candidate = candidates[i];
                // 这句是"避免答案集合中有重复组合"的关键
                // 要跳过"同一层级"的重复数字, 但是不能跳过不同层级的同一数字
                // "同一层级"的重复数字特点就是 i != begin && candidates[i - 1] == candidate
                if (i != begin && candidates[i - 1] == candidate) {
                    continue;
                }
                if (target - candidate < 0) {
                    break; // return
                } else {
                    path.addLast(candidate);
                    // 和39题的差异: begin 传参 i + 1, 因为一个组合中同个元素只允许用一次
                    dfs(candidates, i + 1, target - candidate, result, path);
                    path.removeLast();
                }
            }
        }
    }
}
