package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题49-丑数
 * @since 2020.09.28 23:58
 */

public class ToOffer_49_UglyNumber {
    public int nthUglyNumber(int n) {
        // 分别对应因子
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int a2 = dp[i2] * 2;
            int a3 = dp[i3] * 3;
            int a5 = dp[i5] * 5;
            dp[i] = Math.max(Math.max(a2, a3), a5);
            if (dp[i] == a2) {
                i2++;
            } else if (dp[i] == a3) {
                i3++;
            } else {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
