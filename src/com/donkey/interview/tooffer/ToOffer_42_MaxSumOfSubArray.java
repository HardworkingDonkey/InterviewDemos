package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题42-连续子数组的最大和
 * @since 2020.09.28 14:08
 */

public class ToOffer_42_MaxSumOfSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        // 动态规划
        // 将数组的元素更新为从首元素到当前元素的连续子数组最大和
        for (int i = 1; i < nums.length; i++) {
            // 当前元素加上 max(首元素到上一元素的连续子数组最大和, 0)
            // 也就是如果首元素到上一元素的连续子数组最大和为负
            // 则当前元素不与前面的元素组合成子数组
            nums[i] += Math.max(nums[i - 1], 0);
            // 保存记录最大和
            result = Math.max(nums[i], result);
        }
        return result;
    }
}
