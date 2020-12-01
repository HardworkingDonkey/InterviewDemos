package com.donkey.interview.leetcode;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-039-组合总和
 * @since 2020.12.01 9:58
 */

public class LeetCode_039_CombinationSum {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (candidates == null || candidates.length == 0) {
//            return result;
//        }
//        Arrays.sort(candidates);
//        Deque<Integer> path = new ArrayDeque<>();
//        dfs(candidates, target, result, path, 0);
//        return result;
//    }
//
//    private void dfs(int[] candidates, int target, List<List<Integer>> result, Deque<Integer> path, int begin) {
//        if (target == 0) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = begin; i < candidates.length; i++) {
//            if (target - candidates[i] < 0) {
//                break;
//            }
//            path.addLast(candidates[i]);
//            dfs(candidates, target - candidates[i], result, path, i);
//            path.removeLast();
//        }
//    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        // 对给定数组进行排序是"剪枝"的必要步骤
        Arrays.sort(candidates);
        // 保存深度遍历时路径
        Deque<Integer> path = new LinkedList<>();
        dfs(candidates, 0, target, result, path);
        return result;
    }

    /**
     * @param candidates 给定数组
     * @param begin      从数组哪个位置开始
     * @param target     目标结果
     * @param result     结果集合
     * @param path       深度遍历时的路径
     * @return void
     */
    private void dfs(int[] candidates, int begin, int target, List<List<Integer>> result, Deque<Integer> path) {
        // 如果到达该层时目标数已经减为0, 说明此时路径中的数就是符合要求的结果集
        if (target == 0) {
            result.add(new ArrayList<>(path));
        } else { // 否则要继续往下深度遍历
            for (int i = begin; i < candidates.length; i++) {
                int candidate = candidates[i];
                // 如果目标减去当前遍历到的数为负数
                if (target - candidate < 0) {
                    // "剪枝"
                    break;
                }
                // 将当前元素加到路径中
                path.addLast(candidate);
                // 递归传参 begin = i, 则是为了下一层遍历仍从本层的同个数字开始
                dfs(candidates, i, target - candidate, result, path);
                // 还原
                path.removeLast();
            }
        }
    }
}
