package com.donkey.interview.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-054-螺旋矩阵
 * @since 2020.12.07 9:13
 */

public class LeetCode_054_SpiralOrder {
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> result = new ArrayList<>();
//        if (matrix == null || matrix.length == 0) {
//            return result;
//        }
//        // 遍历层数 = (矩阵的短边的边长 + 1) / 2
//        int height = matrix.length; // 3
//        int width = matrix[0].length; // 3
//        int layer = (Math.min(height, width) + 1) / 2; // 2
//        for (int i = 0; i < layer; i++) { // 2次
//            // 往右
//            for (int j = 0; j < width - 2 * i - 1; j++) {
//                result.add(matrix[i][i + j]);
//            }
//            // 往下
//            for (int j = 0; j < height - 2 * i - 1; j++) {
//                result.add(matrix[i + j][width - i - 1]);
//            }
//            // 往左
//            for (int j = 0; j < width - 2 * i - 1; j++) {
//                result.add(matrix[height - i - 1][width - i - j - 1]);
//            }
////            // 往上
////            for (int j = 0; j < height - 2 * i - 1; j++) {
////                result.add(matrix[height - i - j - 1][i]);
////            }
//        }
//        // 补上最中间的元素
//        if (width == height) {
//            result.add(matrix[height / 2][width / 2]);
//        }
//        return result;
//    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int rows = matrix.length;
        if (rows == 0) {
            return new ArrayList<>();
        }
        int cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        // 当 start * 2 < rows && start * 2 < cols 循环继续
        for (int start = 0; start * 2 < rows && start * 2 < cols; start++) {
            print(matrix, start, rows, cols, result);
        }
        return result;
    }

    public void print(int[][] matrix, int start, int rows, int cols, List<Integer> result) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        // 从左到右
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }
        // 当矩阵不止一行时, 从上到下
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
            // 当矩阵不止一行且不止一列时, 从右到左
            if (endX > start) {
                for (int i = endX - 1; i >= start; i--) {
                    result.add(matrix[endY][i]);
                }
                // 当矩阵不止一列且不止两行时, 从下到上
                if (endY >= start + 2) {
                    for (int i = endY - 1; i >= start + 1; i--) {
                        result.add(matrix[i][start]);
                    }
                }
            }
        }
    }

//    @Test
//    public void test() {
//        int[][] matrix = {{1, 2, 3}, {1, 2, 3}};
//        List<Integer> integers = spiralOrder(matrix);
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }
//    }
}
