package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-027-移除元素
 * @since 2020.11.27 13:45
 */

public class LeetCode_027_RemoveElementInArray {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义快慢指针i, j
        int i = 0, j = 0;
        while (j < nums.length) {
            // 跳过为val的值
            if (nums[j] == val) {
                j++;
            } else { // 只给前几个元素赋值为非val的值
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
