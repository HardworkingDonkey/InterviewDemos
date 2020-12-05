package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-048-顺时针90度旋转矩阵
 * @since 2020.12.05 10:47
 */

public class LeetCode_048_RotateMatrix {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 0) {
            return;
        }
        // 层数不超过数组长度 / 2
        for (int layer = 0; layer < length / 2; layer++) {
            // 将每一层分为四个该层长度 - 1的
            for (int i = 0; i < length - layer * 2 - 1; i++) {
//                int num1 = matrix[layer][layer + i]; // 上
//                int num2 = matrix[layer + i][length - layer - 1]; // 右
//                int num3 = matrix[length - layer - 1][length - layer - 1 - i]; // 下
//                int num4 = matrix[length - layer - i - 1][layer]; // 左
                int temp = matrix[layer][layer + i];
                matrix[layer][layer + i] = matrix[length - layer - i - 1][layer];
                matrix[length - layer - i - 1][layer] = matrix[length - layer - 1][length - layer - 1 - i];
                matrix[length - layer - 1][length - layer - 1 - i] = matrix[layer + i][length - layer - 1];
                matrix[layer + i][length - layer - 1] = temp;
            }
        }
    }
}
