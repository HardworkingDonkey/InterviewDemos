package com.donkey.interview.leetcode;

/**
 * @Author 刻苦驴
 * @Date 2020.05.08
 * @Time 14:08
 * @Package PACKAGE_NAME
 * @Description LeetCode(8)-字符串转换整数
 */

public class LeetCode_008_myAtoi {
    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        boolean positive = true; // 保存正负
        // i是索引
        int base = 0, n = str.length(), i = 0;
        // 在第一个非空字符停下
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        // 判断第一个字符是否为正负号
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            // 相当于 positive = (str.charAt(i++) == '+') ? positive : false;
            // 相当于 positive = (str.charAt(i++) == '+') && positive;
            positive = str.charAt(i++) == '+';
        }
        // 判断各位字符是否是数字, 与'0'/'9'比较时是用ASCII码
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // 最大的数是： 2147483647
            // 最小的数是：-2147483648
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return positive ? base : base * (-1);
    }
}
