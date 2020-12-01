package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-034-在排序数组中查找元素的第一个和最后一个位置
 * @since 2020.11.29 14:03
 */

public class LeetCode_034_SearchFirstAndLastInSortedArray {
//    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
//        int lo = 0;
//        int hi = nums.length;
//
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if (nums[mid] > target || (left && target == nums[mid])) {
//                hi = mid;
//            } else {
//                lo = mid + 1;
//            }
//        }
//
//        return lo;
//    }
//
//    public int[] searchRange(int[] nums, int target) {
//        int[] targetRange = {-1, -1};
//
//        int leftIdx = extremeInsertionIndex(nums, target, true);
//
//        // assert that `leftIdx` is within the array bounds and that `target`
//        // is actually in `nums`.
//        if (leftIdx == nums.length || nums[leftIdx] != target) {
//            return targetRange;
//        }
//
//        targetRange[0] = leftIdx;
//        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
//
//        return targetRange;
//    }


    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int i = 0, j = nums.length - 1;
        // 先找出target的左边界
        while (i < j) {
            int mid = (i + j) >> 1;
            // 如果中间数>=目标, 则左边界在mid左边
            if (nums[mid] >= target) {
                j = mid;
            } else { // 反之在mid及其右边
                i = mid + 1;
            }
        }
        // 如果索引越界或者索引所指数不等于目标, 则说明没有找到目标
        if (i >= nums.length || nums[i] != target) {
            return result;
        }
        result[0] = i;
        i = 0;
        j = nums.length;
        // 接着找出target的右边界
        while (i < j) {
            int mid = (i + j) >> 1;
            if (nums[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        result[1] = j - 1;
        return result;
    }
}
