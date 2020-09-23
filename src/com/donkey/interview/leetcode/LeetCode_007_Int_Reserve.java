package com.donkey.interview.leetcode;

/**
 * @Author 刻苦驴
 * @Date 2020.05.07
 * @Time 11:43
 * @Package PACKAGE_NAME
 * @Description LeetCode(7)-整数反转
 */

public class LeetCode_007_Int_Reserve {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

}
