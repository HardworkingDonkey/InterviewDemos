package com.donkey.interview.leetcode;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-047-全排列II
 * @since 2020.12.05 9:14
 */

public class LeetCode_047_Permutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 排序是剪枝的前提
        Arrays.sort(nums);
        // 中间变量, 深度遍历过程中的路径
        Deque<Integer> path = new LinkedList<>();
        // 标记元素是否被使用过
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, path, result);
        return result;
    }

    private void dfs(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        // 如果中间变量path长度等于数组长度, 添加结果
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 避免深度遍历的同一层出现一样的数字
                // 当前数字和前一个数字相同时
                // 如果前一个数字"未使用", 则说明同一层已经使用过这个数字
                // 如果前一个数字"已使用", 则说明是不同层
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                path.addLast(nums[i]);
                dfs(nums, used, path, result);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
