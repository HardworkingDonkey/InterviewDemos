package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-078-子集
 * @since 2020.12.16 10:11
 */

public class LeetCode_078_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // 空集
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, 0, path, result);
        return result;
    }

    private void dfs(int[] nums, int start, Deque<Integer> path, List<List<Integer>> result) {
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            result.add(new LinkedList<>(path));
            dfs(nums, i + 1, path, result);
            path.removeLast();
        }
    }
}
