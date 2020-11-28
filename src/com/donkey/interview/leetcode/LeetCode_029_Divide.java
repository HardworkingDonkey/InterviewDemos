package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description 不使用乘、除和 mod 进行除法运算
 * @since 2020.11.28 9:19
 */

public class LeetCode_029_Divide {
//    int divide(int dividend, int divisor) {
//        // 被除数为0直接返回0
//        if (dividend == 0) {
//            return 0;
//        }
//        if (divisor == 1) {
//            return dividend;
//        }
//        if (divisor == -1) {
//            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
//        }
//        // 记录结果正负的符号
//        int sign = 1;
//        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
//            sign = -1;
//        }
//        // 将数字取绝对值
//        dividend = dividend > 0 ? dividend : -dividend;
//        divisor = divisor > 0 ? divisor : -divisor;
//        long result = div(dividend == Integer.MIN_VALUE ? 2147483648L : dividend, divisor == Integer.MIN_VALUE ? 2147483648L : divisor);
//        if (result > Integer.MAX_VALUE) {
//            return Integer.MAX_VALUE;
//        }
//        return (int) (sign == 1 ? result : -result);
//    }
//
//    private long div(long dividend, long divisor) {
//        // 如果被除数比除数小, 直接返回0
//        if (dividend < divisor) {
//            return 0;
//        }
//        // 被除数比除数大, 则被除数至少有1个除数(数值比较)
//        // count记录被除数的数值等于几个除数
//        long count = 1;
//        // 既然count至少为1, 那就尝试让除数翻倍, 看看count能否达到2
//        long curDivisor = divisor;
//        while (dividend > curDivisor + curDivisor) {
//            count += count; // 结果翻倍
//            curDivisor += curDivisor; // 被除数翻倍
//        }
//        // 还需要检查dividend减去curDivisor后是否还能包括几个divisor
//        return count + div(dividend - curDivisor, divisor);
//    }

    int divide(int dividend, int divisor) {
        // 被除数为0直接返回0
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        // 记录结果正负的符号
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        // 原先采用绝对值来计算, 但是整数最小值取相反数会溢出
        // 所以将数统统置为负数, 直接用两个负数计算
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int result = div(dividend, divisor);
        return sign == 1 ? result : -result;
    }

    private int div(int dividend, int divisor) {
        // 如果被除数比除数大, 直接返回0
        // 注意这里都是负数, 所以比较的是绝对值
        if (dividend > divisor) {
            return 0;
        }
        // 被除数比除数小(绝对值大), 则被除数至少有1个除数(数值比较)
        // count记录被除数的数值等于几个除数
        int count = 1;
        // 既然count至少为1, 那就尝试让除数翻倍, 看看count能否达到2
        int curDivisor = divisor;
        while (dividend < curDivisor + curDivisor && curDivisor + curDivisor < 0) {
            count += count; // 结果翻倍
            curDivisor += curDivisor; // 被除数翻倍
        }
        // 还需要检查dividend减去curDivisor后是否还能包括几个divisor
        return count + div(dividend - curDivisor, divisor);
    }

//    public static void main(String[] args) {
//        int a = Integer.MIN_VALUE;
//        System.out.println(a - 1); // 整型最小值 - 1 = 整型最大值
//    }
}
