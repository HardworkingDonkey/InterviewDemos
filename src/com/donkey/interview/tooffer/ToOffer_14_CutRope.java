package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题14-剪绳子
 * @since 2020.09.22 0:22
 */

public class ToOffer_14_CutRope {
    // 数学证明:
    // n >= 5时, 2(n-2) > n 且 3(n-3) > n, 也就是绳子剩余长度 >= 5时, 将绳子剪成 2 或 3
    // n >= 5时, 3(n-3) >= 2(n-2), 所以尽量剪成 3
    // n == 4时, 3 * 1 < 2 * 2, 所以长度为4时剪成 2 + 2
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int timesOf3 = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, timesOf3);
        }
        if (b == 1) {
            return (int) (Math.pow(3, timesOf3 - 1) * 4);
        }
        return (int) (Math.pow(3, timesOf3) * 2);
    }
}
