package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题62-圆圈中最后剩下的数字
 * @since 2020.10.07 20:22
 */

public class ToOffer_62_LastNumInLoop {
    // 人数为1： 0
    // 人数为2： (0+m) % 2
    // 人数为3： ((0+m) % 2 + m) % 3
    // 人数为4： (((0+m) % 2 + m) % 3 + m) % 4
    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
