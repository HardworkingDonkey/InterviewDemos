package com.donkey.interview.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-079-单词搜索
 * @since 2020.12.16 10:58
 */

public class LeetCode_079_WordSearch {
    int m;
    int n;
    int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // 上下左右

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, used, 0, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] used, int index, int i, int j, String word) {
        if (!used[i][j] && board[i][j] == word.charAt(index)) {
            used[i][j] = true;
            if (index + 1 == word.length()) {
                return true;
            }
            for (int[] direct : direction) {
                int newI = i + direct[0];
                int newJ = j + direct[1];
                if (isValid(newI, newJ)) {
                    if (dfs(board, used, index + 1, newI, newJ, word)) {
                        return true;
                    }
                }
            }
            used[i][j] = false;
        }
        return false;
    }

    private boolean isValid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}
