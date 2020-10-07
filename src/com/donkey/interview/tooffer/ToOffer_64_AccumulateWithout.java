package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题64-不使用乘除和循环语句求和
 * @since 2020.10.07 21:08
 */

public class ToOffer_64_AccumulateWithout {
    public int sumNums(int n) {
        boolean b = n > 1 && (n += sumNums(n - 1)) > 0;
        return n; // 等于1时直接返回
    }
}
