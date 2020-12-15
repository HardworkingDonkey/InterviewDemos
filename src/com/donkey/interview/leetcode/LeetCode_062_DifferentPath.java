package com.donkey.interview.leetcode;

import java.util.Arrays;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-062-不同路径
 * @since 2020.12.11 23:13
 */

public class LeetCode_062_DifferentPath {
    // 思路正确, 但是超时
//    int count = 0;
//    public int uniquePaths(int m, int n) {
//        dfs(1, 1, m, n);
//        return count;
//    }
//
//    private void dfs(int row, int col, int m, int n) {
//        if (row == m && col == n) {
//            count++;
//            return;
//        }
//        if (row < m) {
//            dfs(row + 1, col, m, n);
//        }
//        if (col < n) {
//            dfs(row, col + 1, m, n);
//        }
//    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
