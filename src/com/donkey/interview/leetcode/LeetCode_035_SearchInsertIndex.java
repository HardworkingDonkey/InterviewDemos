package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-035-搜索插入的位置
 * @since 2020.11.30 8:55
 */

public class LeetCode_035_SearchInsertIndex {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) {
            int mid = (i + j) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j;
    }
}
