package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.08
 * @Time 23:01
 * @Package PACKAGE_NAME
 * @Description 面试4-二维数组中的查找
 */

public class ToOffer_04_FindIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
