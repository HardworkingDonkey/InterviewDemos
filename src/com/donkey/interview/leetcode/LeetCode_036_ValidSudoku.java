package com.donkey.interview.leetcode;

import java.util.HashMap;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-36-有效的数独
 * @since 2020.11.30 9:30
 */

public class LeetCode_036_ValidSudoku {
    // 53%, 76%
//    public boolean isValidSudoku(char[][] board) {
//        HashMap<Integer, Integer>[] rows = new HashMap[9];
//        HashMap<Integer, Integer>[] cols = new HashMap[9];
//        HashMap<Integer, Integer>[] boxes = new HashMap[9];
//        for (int i = 0; i < 9; i++) {
//            rows[i] = new HashMap<>();
//            cols[i] = new HashMap<>();
//            boxes[i] = new HashMap<>();
//        }
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                char numChar = board[i][j];
//                if (numChar != '.') {
//                    int num = numChar - '0';
//                    if (rows[i].containsKey(num)) {
//                        return false;
//                    } else {
//                        rows[i].put(num, 1);
//                    }
//                    if (cols[j].containsKey(num)) {
//                        return false;
//                    } else {
//                        cols[j].put(num, 1);
//                    }
//                    if (boxes[i / 3 * 3 + j / 3].containsKey(num)) {
//                        return false;
//                    } else {
//                        boxes[i / 3 * 3 + j / 3].put(num, 1);
//                    }
//                }
//            }
//        }
//        return true;
//    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char numChar = board[i][j];
                if (numChar != '.') {
                    int num = numChar - '0';
                    if (rows[i][num - 1]) {
                        return false;
                    } else {
                        rows[i][num - 1] = true;
                    }
                    if (cols[j][num - 1]) {
                        return false;
                    } else {
                        cols[j][num - 1] = true;
                    }
                    if (boxes[i / 3 * 3 + j / 3][num - 1]) {
                        return false;
                    } else {
                        boxes[i / 3 * 3 + j / 3][num - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}
