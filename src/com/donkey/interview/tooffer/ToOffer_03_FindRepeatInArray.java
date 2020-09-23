package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.08
 * @Time 17:41
 * @Package com.donkey.interview.tooffer
 * @Description 面试题3-找出数组中重复的数
 */

public class ToOffer_03_FindRepeatInArray {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] != nums[nums[i]]) {
                    // 交换 nums[i] 和 nums[nums[i]]
                    temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[temp] = temp;
                } else {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
