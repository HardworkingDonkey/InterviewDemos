package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-075-颜色分类
 * @since 2020.12.15 21:59
 */

public class LeetCode_075_SortColors {
    // 太简单
//    public void sortColors(int[] nums) {
//        int[] counts = new int[3];
//        for (int num : nums) {
//            counts[num]++;
//        }
//        int index = 0;
//        for (int i = 0; i < counts[0]; i++) {
//            nums[index++] = 0;
//        }
//        for (int i = 0; i < counts[1]; i++) {
//            nums[index++] = 1;
//        }
//        for (int i = 0; i < counts[2]; i++) {
//            nums[index++] = 2;
//        }
//    }

    public void sortColors(int[] nums) {
        int zero = 0; // 用于将0换到最前面
        int two = nums.length - 1; // 用于将2放到最后面
        for (int i = 0; i < two; i++) {
            while (nums[i] == 2) {
                swap(nums, two--, i);
            }
            if (nums[i] == 0) {
                swap(nums, zero++, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
