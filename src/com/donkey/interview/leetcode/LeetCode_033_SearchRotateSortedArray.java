package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-033-搜索旋转排序数组
 * @since 2020.11.29 9:14
 */

public class LeetCode_033_SearchRotateSortedArray {
    //    public int search(int[] nums, int target) {
//        int i = 0, j = nums.length - 1;
//        while (i < j) {
//            int mid = (i + j) >> 1;
//            if (nums[mid] == target) {
//                return mid;
//            }
//            if (nums[i] <= nums[mid]) {
//                if (target >= nums[i] && target < nums[mid]) {
//                    j = mid - 1;
//                } else {
//                    i = mid + 1;
//                }
//            } else {
//                if (target > nums[mid] && target <= nums[j]) {
//                    i = mid + 1;
//                } else {
//                    j = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        // 左右指针
        int i = 0, j = nums.length - 1;
        while (i < j) {
            // 中间指针
            int mid = (i + j) >> 1;
            // 中间数等于目标时返回
            if (nums[mid] == target) {
                return mid;
            }
            // 如果左端的数小于中间的数, 则该区间是递增区间
            if (nums[i] <= nums[mid]) {
                // 如果目标刚好在递增区间内
                if (nums[i] <= target && target < nums[mid]) {
                    // 区间右端往中间移动
                    j = mid - 1;
                } else { // 不在递增区间内则左端往中间移动
                    i = mid + 1;
                }
            } else { // 递增区间在右边
                // 如果目标在递增区间内
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return nums[i] == target ? i : -1;
    }
}
