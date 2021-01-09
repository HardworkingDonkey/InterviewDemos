package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-081-搜索旋转排序数组II
 * @since 2020.12.20 9:22
 */

public class LeetCode_081_SearchRotateArray {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (nums[mid] == target) {
                return true;
            }
            // 针对极端情况, 有很多重复数字
            while (i < j && nums[i] == nums[mid]) {
                i++;
            }
            if (nums[mid] <= nums[j]) { // 则[中间, 右]是递增的
                // 且目标值在[中间, 右]之中
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid;
                } else {
                    j = mid - 1;
                }
            } else { // 如果[左, 中间]是递增的
                // 且目标值在[左, 中间]之中
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid;
                }
            }
        }
        return nums[i] == target;
    }
}
