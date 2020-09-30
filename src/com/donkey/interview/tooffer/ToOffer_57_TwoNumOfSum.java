package com.donkey.interview.tooffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题57-和为S的两个数
 * @since 2020.09.30 14:04
 */

public class ToOffer_57_TwoNumOfSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 2) {
            return new int[]{};
        }
        int i = 0;
        int j = len - 1;
        int small = nums[i];
        int big = nums[j];
        while (i < j) {
            int sum = small + big;
            if (sum == target) {
                return new int[]{small, big};
            } else if (sum < target) {
                small = nums[++i];
            } else {
                big = nums[--j];
            }
        }
        return new int[]{small, big};
    }

    // 用一个滑动窗口, 两个指针`i, j`一左一右
    // 计算两个指针范围内所有数之和
    // 计算和:
    // * 一开始先`i = 1, j = 2, sum = 1 + 2`
    // * 判断sum与target的关系
    //     * 如果等于, 则将序列添加到结果集, 并且`sum += ++j`(这里注意是`++j`, 因为下一轮窗口往右拓展, 需要加上j + 1)
    //     * 如果小于, 则也是窗口往右拓展`sum += ++j`
    //     * 如果大于, 则窗口左边需要往右移动, `sum -= i++`(注意这里是`i++`, 因为需要减掉`i`然后再往右移动)
    // * 优化点: 避免重复计算, 不采用等差数列求和公式, 而是直接利用上一次的计算结果进行加减
    public int[][] findContinuousSequence(int target) {
        LinkedList<int[]> result = new LinkedList<>();
        int sum = 1 + 2;
        for (int i = 1, j = 2; i < j; ) {
            // 等差数列公式
            if (sum == target) {
                int[] seq = new int[j - i + 1];
                for (int k = 0; k < seq.length; k++) {
                    seq[k] = i + k;
                }
                result.add(seq);
                sum += ++j;
            } else if (sum < target) {
                sum += ++j;
            } else {
                sum -= i++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
