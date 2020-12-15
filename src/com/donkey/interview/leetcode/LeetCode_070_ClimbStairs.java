package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-070-爬楼梯
 * @since 2020.12.13 23:44
 */

public class LeetCode_070_ClimbStairs {
    // f(n) = f(n - 1) + f(n - 2)
    public int climbStairs(int n) {
        if (n <= 2) {
            return n; // f(0) = 0, f(1) = 1, f(2) = 2
        }
        int a = 1; // n = 1
        int b = 2; // n = 2
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
