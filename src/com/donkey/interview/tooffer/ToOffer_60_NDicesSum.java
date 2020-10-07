package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题60-N个骰子的点数
 * @since 2020.10.07 16:37
 */

public class ToOffer_60_NDicesSum {
    public double[] twoSum(int n) {
        // n个骰子的点数 = 1个骰子的点数 + (n - 1)个骰子的点数
        // 1个骰子的点数概率很容易知道: 1到6每个概率都为 1/6
        // n个骰子的点数可能性有 (6n - n + 1) = 5n + 1种
        double[] pre = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        // 1个骰子的情况显而易见, 从2开始
        for (int i = 2; i <= n; i++) {
            // 每一轮的可能性有 5 * i + 1 种
            double[] tmp = new double[5 * i + 1];
            // 遍历上一轮的概率数组
            for (int j = 0; j < pre.length; j++) {
                // 该循环是将前 n - 1 个骰子某一点数的概率 * 1个骰子的每个点数概率1/6
                // 得到本轮的概率数组
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += pre[j] / 6d;
                }
            }
            // 更新"前n - 1个骰子"的概率数组
            pre = tmp;
        }
        return pre;
    }
}
