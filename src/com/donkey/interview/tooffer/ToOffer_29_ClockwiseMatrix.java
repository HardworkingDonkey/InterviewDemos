package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题29-顺时针打印矩阵
 * @since 2020.09.23 18:17
 */

public class ToOffer_29_ClockwiseMatrix {
    int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        // 当start * 2 < rows && start * 2 < cols循环继续
        for (int start = 0; start * 2 < rows && start * 2 < cols; start++) {
            print(matrix, start, rows, cols, result);
        }
        return result;
    }

    public void print(int[][] matrix, int start, int rows, int cols, int[] result) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        // 从左到右
        for (int i = start; i <= endX; i++) {
            result[index++] = matrix[start][i];
        }
        // 当矩阵不止一行时, 从上到下
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                result[index++] = matrix[i][endX];
            }
            // 当矩阵不止一行且不止一列时, 从右到左
            if (endX > start) {
                for (int i = endX - 1; i >= start; i--) {
                    result[index++] = matrix[endY][i];
                }
                // 当矩阵不止一列且不止两行时, 从下到上
                if (endY >= start + 2) {
                    for (int i = endY - 1; i >= start + 1; i--) {
                        result[index++] = matrix[i][start];
                    }
                }
            }
        }
    }
}
