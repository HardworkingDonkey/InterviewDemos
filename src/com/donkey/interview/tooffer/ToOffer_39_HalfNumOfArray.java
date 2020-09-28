package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题39-数组中出现次数超过一半的数
 * @since 2020.09.28 10:34
 */

public class ToOffer_39_HalfNumOfArray {
    public int majorityElement(int[] nums) {
        int mode = nums[0]; // 众数
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                mode = num;
            }
            vote += mode == num ? 1 : -1;
        }
        return mode;
    }
}
