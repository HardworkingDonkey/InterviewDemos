package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-050-实现pow()
 * @since 2020.12.06 10:08
 */

public class LeetCode_050_Pow {
    public double myPow(double x, int n) {
        if (x == 0.0) {
            return 0.0;
        }
        long pow = n; // 防止取相反数时溢出
        if (pow < 0) {
            x = 1.0 / x;
            pow = -pow;
        }
        double result = 1;
        while (pow > 1) {
            // 如果pow是奇数
            if ((pow & 0x1) == 0x1) {
                result *= x;
            }
            x *= x;
            // pow 除以 2
            pow >>= 1;
        }
        return result;
    }
}
