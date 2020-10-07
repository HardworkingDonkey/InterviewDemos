package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题65-不用加减乘除做加法
 * @since 2020.10.07 21:33
 */

public class ToOffer_65_AdditionWithoutFourOperation {
    public int add(int a, int b) {
        // 两数相加 = 各位相加 + 进位
        // 99 + 9 = 98(非进位和) + 10(进位)
        //        = 8(非进位和) + 100(进位)
        //        = 108(非进位和) + 0(进位)
        // 直到进位为0结束
        // 观察 a + b 当a, b取值分别为0, 1时非进位和和进位的情况
        // 可知, 进位 = (a & b) << 1, 非进位和 = a ^ b
        while (b != 0) { // 当进位为0时跳出
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}
