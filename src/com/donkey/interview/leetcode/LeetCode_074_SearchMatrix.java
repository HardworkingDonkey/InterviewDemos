package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-074-搜索二维矩阵
 * @since 2020.12.15 20:27
 */

public class LeetCode_074_SearchMatrix {
    // 从左到右递增, 从上到下递增
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 遍历时从"右上角"开始遍历
        for (int i = 0, j = n - 1; i < m && j >= 0; ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) { // 当前数小于目标数
                // 则直接忽略该行, 因为每一行从左到右递增
                i++;
            } else { // 当前数大于目标数
                // 则直接忽略该列, 因为每一列从上到下递增
                j--;
            }
        }
        return false;
    }
}
