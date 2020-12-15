package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-063-不同路径II
 * @since 2020.12.11 23:59
 */

public class LeetCode_063_DifferentPath {
    // 100%, 10%
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid[0][0] == 1) {
//            return 0;
//        }
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            if (obstacleGrid[i][0] != 1) {
//                dp[i][0] = 1;
//            } else { // 被障碍物挡到, 后面都不能走通
//                break;
//            }
//        }
//        for (int i = 1; i < n; i++) {
//            if (obstacleGrid[0][i] != 1) {
//                dp[0][i] = 1;
//            } else {
//                break;
//            }
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if (obstacleGrid[i][j] != 1) {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                }
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    // 100%, 90%
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j >= 1 && obstacleGrid[i][j - 1] == 0) {
                    // 相当于将[i - 1][j]的结果 += [i][j - 1]然后赋给[i][j]
                    // 滚动数组
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
