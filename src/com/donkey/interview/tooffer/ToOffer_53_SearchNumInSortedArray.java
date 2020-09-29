package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题53-在排序数组中查找数字
 * @since 2020.09.29 14:59
 */

public class ToOffer_53_SearchNumInSortedArray {
    public int search(int[] nums, int target) {
        return getRight(nums, target) - getRight(nums, target - 1);
    }

    public int getRight(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else if (nums[m] > m) {
                j = m;
            }
        }
        return i;
    }
}
