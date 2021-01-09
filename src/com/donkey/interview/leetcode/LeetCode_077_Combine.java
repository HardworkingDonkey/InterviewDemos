package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-077-组合
 * @since 2020.12.15 23:35
 */

public class LeetCode_077_Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path, result);
        return result;
    }

    private void dfs(int n, int k, int i, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
        } else {
            // 当前索引 <= n - 还需要选择的元素个数 + 1
            for (int j = i; j <= n - (k - path.size()) + 1; j++) {
                path.addLast(j);
                dfs(n, k, j + 1, path, result);
                path.removeLast();
            }
        }
    }
}
