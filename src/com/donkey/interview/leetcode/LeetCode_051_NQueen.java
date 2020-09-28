package com.donkey.interview.leetcode;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode51-N皇后(未完成)
 * @since 2020.09.28 8:53
 */

public class LeetCode_051_NQueen {
//    int[] colIndex;
//
//    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//        // 存储中间结果
//        Deque<Integer> tmp = new ArrayDeque<>();
//        // 标记数组中的所有数字有无被使用
//        boolean[] used = new boolean[len];
//        // 回溯算法(数组, 长度, 深度, 中间结果, 标记数组, 结果集合)
//        dfs(nums, len, 0, tmp, used, res);
//        return res;
//    }
//
//    private void dfs(int[] nums, int len, int depth, Deque<Integer> tmp, boolean[] used, List<List<Integer>> res) {
//        // 如果深度 == 长度, 说明排列已经到了最后一位, 可以加入结果集
//        if (depth == len) {
//            for (int i = 0; i < nums.length - 1; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (i - j == colIndex[i] - colIndex[j]) {
//                        return;
//                    }
//                }
//            }
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//        // 遍历数组, 每个数字都有可能要被遍历
//        for (int i = 0; i < len; i++) {
//            // 如果当前数没被使用
//            if (!used[i]) {
//                // 加到中间结果
//                tmp.addLast(nums[i]);
//                // 并设置为已遍历
//                used[i] = true;
//                // 递归, 深度 + 1
//                dfs(nums, len, depth + 1, tmp, used, res);
//                // 回溯后, 设置为未遍历以及移出
//                used[i] = false;
//                tmp.removeLast();
//            }
//        }
//    }
//
//    public List<List<String>> solveNQueens(int n) {
//        colIndex = new int[n];
//        // 初始化索引, 数组第i个数表示第i行的皇后的列号
//        for (int i = 1; i < n; i++) {
//            colIndex[i] = i;
//        }
//        List<List<Integer>> permute = permute(colIndex);
//        List<List<String>> res = new LinkedList<>();
//        for (int i = 0; i < permute.size(); i++) {
//            List<Integer> cols = permute.get(i);
//            List<String> rank = new LinkedList<>();
//            for (int j = 0; j < n; j++) {
//                StringBuilder tmp = new StringBuilder();
//                for (int k = 0; k < n; k++) {
//                    if (k == cols.get(j)) {
//                        tmp.append("Q");
//                    } else {
//                        tmp.append(".");
//                    }
//                }
//                rank.add(tmp.toString());
//            }
//            res.add(rank);
//        }
//        return res;
//    }
}
