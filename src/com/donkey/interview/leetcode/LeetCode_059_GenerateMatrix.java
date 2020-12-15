package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-059-螺旋矩阵II
 * @since 2020.12.10 22:59
 */

public class LeetCode_059_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 层数 = (n + 1) / 2
        int layer = (n + 1) / 2;
        // 填的数字
        int num = 1;
        for (int i = 0; i < layer; i++) {
            // 每一层分成四部分, 每部分的长度
            int partLength = n - i * 2 - 1;
            int start = num;
            for (int j = 0; j < partLength; j++) {
                // result[i][i + j] 上
                // result[i + j][n - i - 1] 右
                // result[n - i - 1][n - i - 1 - j] 下
                // result[n - i - 1 - j][i] 左
                result[i][i + j] = start + j;
                result[i + j][n - i - 1] = result[i][i + j] + partLength;
                result[n - i - 1][n - i - 1 - j] = result[i + j][n - i - 1] + partLength;
                result[n - i - 1 - j][i] = result[n - i - 1][n - i - 1 - j] + partLength;
            }
            num = num + partLength * 4;
        }
        // 如果n是奇数, 还需要补上最中间的元素
        if ((n & 0x1) == 0x1) {
            result[n / 2][n / 2] = n * n;
        }
        return result;
    }
}
