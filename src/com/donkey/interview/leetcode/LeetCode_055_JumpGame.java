package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-055-跳跃游戏
 * @since 2020.12.08 8:27
 */

public class LeetCode_055_JumpGame {
    // 81%, 50%
//    public boolean canJump(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//        int maxPosition = 0;
//        int maxEnd = 0;
//        int i = 0; // 当前位置
//        for (; i < nums.length; i++) {
//            maxPosition = Math.max(maxPosition, i + nums[i]);
//            // 如果到达最远起跳点时最远距离还在原地
//            if (i == maxEnd) {
//                maxEnd = maxPosition;
//                if (i == maxPosition) {
//                    break;
//                }
//            }
//        }
//        return maxPosition >= nums.length - 1;
//    }

    // 81%, 70%
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPosition) {
                return false;
            }
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }
        return true;
    }
}
