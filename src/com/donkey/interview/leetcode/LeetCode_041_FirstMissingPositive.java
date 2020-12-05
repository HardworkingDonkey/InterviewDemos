package com.donkey.interview.leetcode;

import java.util.Arrays;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-041-缺失的第一个正数
 * @since 2020.12.02 9:21
 */

public class LeetCode_041_FirstMissingPositive {
    // 自己写的
//    public int firstMissingPositive(int[] nums) {
//        int result = 1;
//        Arrays.sort(nums);
//        for (int num : nums) {
//            if (num == result) {
//                result = num + 1;
//            }
//        }
//        return result;
//    }

    // 推荐答案
    public int firstMissingPositive(int[] nums) {
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 试图将元素1放在位置0, 元素2放在位置1, ...以此类推
            // 忽略负数和超过数组长度的数
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 调整完数组后, 遍历数组, 找出第一个不符合"元素值 = 索引 + 1"的即为答案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 如果全都满足则直接返回数组长度 + 1
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
