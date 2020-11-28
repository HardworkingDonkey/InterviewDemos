package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-031-下一个排列
 * @since 2020.11.28 11:12
 */

public class LeetCode_031_NextPermutation {
    // 从最后一个元素往前寻找第一个不满足降序排序的数, 记录位置
    // 找到之后在该元素后面的元素中找到比该元素大但是尽可能小的数
    // 两数交换后, 再将记录位置后面的序列翻转
    // 如果找不到不满足降序排列的数, 则说明整个序列是降序的, 已经是最大排列
    // 直接将整个序列翻转
//    public void nextPermutation(int[] nums) {
//        // 从倒数第二个数开始
//        int i = nums.length - 2;
//        // 满足升序则继续往前
//        while (i >= 0 && nums[i] >= nums[i + 1]) {
//            i--;
//        }
//        // 如果i未越界则说明找到了不满足降序的数
//        if (i >= 0) {
//            // 从后往前找到第一个比nums[i]小的并交换位置
//            int j = nums.length - 1;
//            while (j > i && nums[i] >= nums[j]) {
//                j--;
//            }
//            swap(nums, i, j);
//        }
//        reverse(nums, i + 1);
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    public void reverse(int[] nums, int start) {
//        int left = start, right = nums.length - 1;
//        while (left < right) {
//            swap(nums, left, right);
//            left++;
//            right--;
//        }
//    }

    public void nextPermutation(int[] nums) {
        // 从倒数第二个数开始
        int i = nums.length - 2;
        // 满足升序则继续往前
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果i未越界则说明找到了不满足降序的数
        if (i >= 0) {
            // 从后往前找到第一个比nums[i]小的并交换位置
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 翻转数组, 从 i + 1 开始
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
