package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-016-最接近的三数之和
 * @since 2020.10.25 14:52
 */

public class LeetCode_016_ClosestSumOfThreeNums {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 初始化结果
        int result = nums[0] + nums[1] + nums[2];
        // 将数组排序, 从小到大
        Arrays.sort(nums);
        // 遍历数组, 先从最小的数开始, 固定一个数, 然后把问题化解为两数之和
        for (int i = 0; i < nums.length; i++) {
            // 从当前数字的后面, 双指针指向最左最右
            int left = i + 1, right = nums.length - 1;
            // 当两个指针不相遇时(相遇指向同个数, 直接返回)
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 如果和等于目标数, 直接返回
                if (sum == target) {
                    return target;
                } else {
                    // result = result和sum中与target差距小的那个数
                    result = Math.abs(result - target) < Math.abs(sum - target) ? result : sum;
                    if (sum < target) { // 小于目标数则需要增大加数
                        left++;
                    } else { // 反之减小加数
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
