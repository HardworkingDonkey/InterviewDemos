package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.15
 * @Time 23:28
 * @Package PACKAGE_NAME
 * @Description 面试题16-数值的整数次方
 */

public class ToOffer_16_IntPowerOfNumber {
    public double myPow(double x, int n) {
        if (x == 0.0 || x == 1.0 || n == 1) {
            return x;
        }
        if (x == 0.0 && n < 0) {
            return 0.0;
        }
        long absN = n;
        // 负次幂先求正次幂
        if (n < 0) {
            absN = -absN;
        }
        double result = pow(x, absN);
        // 负次幂求倒数
        if (n < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    // 如果n是偶数, 将x^n拆为x^(n/2) * x^(n/2)
    // 如果n是奇数, 将x^n拆为x^((n-1)/2) * x^((n-1)/2) * x
    public double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        // 用右移一位代替除以2, 位运算效率高于数值运算
        double result = pow(x, n >> 1);
        result *= result;
        // 如果是奇次方, 则需要再乘一次基数
        if ((n & 0x1) == 1) {
            result *= x;
        }
        return result;
    }
}
