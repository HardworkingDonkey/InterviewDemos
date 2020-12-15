package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-069-x的平方根
 * @since 2020.12.13 23:01
 */

public class LeetCode_069_MySqrt {
    public int mySqrt(int x) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
