package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-026-删除排序数组中的重复项
 * @since 2020.11.27 13:19
 */

public class LeetCode_026_RemoveDuplicatesInArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义快慢指针
        int i = 0, j = i + 1;
        // 当快指针未越界时
        while (j < nums.length) {
            // 跳过重复值
            if (nums[j] == nums[i]) {
                j++;
            } else { // 遇到不相同的值,
                nums[++i] = nums[j++];
            }
        }
        // 跳出循环时i索引为不重复元素个数 - 1
        return i + 1;
    }
}
