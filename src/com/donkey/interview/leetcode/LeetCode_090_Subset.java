package com.donkey.interview.leetcode;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-090-子集II
 * @since 2021.01.09 21:29
 */

public class LeetCode_090_Subset {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>()); // 空集
        Arrays.sort(nums);
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, 0, path, result);
        return result;
    }

    private void dfs(int[] nums, int start, Deque<Integer> path, List<List<Integer>> result) {
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                path.addLast(nums[i]);
                result.add(new ArrayList<>(path));
                dfs(nums, i + 1, path, result);
                path.removeLast();
            }
        }
    }
}
