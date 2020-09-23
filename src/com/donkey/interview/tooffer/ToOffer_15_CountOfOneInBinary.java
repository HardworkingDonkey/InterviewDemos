package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.16
 * @Time 12:53
 * @Package PACKAGE_NAME
 * @Description 面试题15-二进制数中1的个数
 */

public class ToOffer_15_CountOfOneInBinary {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // 一个数减去1相当于二进制中从最右边的1开始往右的所有位取反
            // 原值 & (原值 - 1) = 原值二进制的最右边的1变为0
            // 所以有几个0, 循环就执行几次, 直到n为0
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
