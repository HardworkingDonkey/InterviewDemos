package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-080-删除排序数组中的重复项II
 * @since 2020.12.16 14:24
 */

public class LeetCode_080_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // i指向要覆盖的位置, j遍历元素
        int j = 1;
        int count = 1;
        for (int i = 1; j < nums.length; ) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
