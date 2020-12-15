package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-066-加一
 * @since 2020.12.13 0:30
 */

public class LeetCode_066_PlusOne {
    // 100%, 70%
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        digits[digits.length - 1]++; // + 1
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i + 1] += digits[i]; // 本位
            result[i] += result[i + 1] / 10; // 前一位加上进位
            result[i + 1] %= 10; //
        }
        boolean flag = result[0] == 1;
        return flag ? result : Arrays.copyOfRange(result, 1, result.length);
    }

    // 100%, 50%
//    public int[] plusOne(int[] digits) {
//        for (int i = digits.length - 1; i >= 0; i--) {
//            digits[i]++;
//            digits[i] %= 10;
//            if (digits[i] != 0) {
//                return digits;
//            }
//        }
//        digits = new int[digits.length + 1];
//        digits[0] = 1;
//        return digits;
//    }
}
