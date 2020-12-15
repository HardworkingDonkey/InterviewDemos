package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-072-编辑距离
 * @since 2020.12.15 16:23
 */

public class LeetCode_072_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        // 长度要 + 1, 考虑到空字符
        int[][] dp = new int[m][n];
        // 第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        // 第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = i;
        }
        // 其余
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果当前遍历到的字符相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j - 1] 是替换字符
                    // dp[i - 1][j] 是删除字符
                    // dp[i][j - 1] 是增加字符
                    // 本次操作 + 替换/删除/增加三种操作中距离最小的
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
