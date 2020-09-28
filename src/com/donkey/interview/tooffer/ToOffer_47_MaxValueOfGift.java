package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题47-礼物的最大价值
 * @since 2020.09.28 18:34
 */

public class ToOffer_47_MaxValueOfGift {
    public int maxValue(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // 初始化第一行
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 初始化第二行
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // f(i, j) = MAX(f(i, j - 1), f(i - 1, j)) + grid[i][j]
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = Math.max(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
