package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-015-三数之和
 * @since 2020.10.25 14:02
 */

public class LeetCode_015_SumOfThreeNums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 将数组排序, 从小到大
        Arrays.sort(nums);
        // 遍历数组, 先从最小的数开始, 固定一个数, 然后把问题化解为两数之和
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数是正数, 则后面三数和不可能是0, 返回
            if (nums[i] > 0) {
                return result;
            }
            // 重复数字, 跳过
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // 从当前数字的后面, 双指针指向最左最右
            int left = i + 1, right = nums.length - 1;
            // 当两个指针不相遇时(相遇指向同个数, 直接返回)
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 如果三数之和刚好是0, 添加到结果集
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 如果左数的后一位是重复的, 则跳过重复的数
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 跳过重复的数之后, 再找下一个数
                    left++;
                    // 如果右数的前一位是重复的, 则跳过重复的数
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 跳过重复的数之后, 再找下一个数
                    right--;
                } else if (sum < 0) { // 小于0则需要增大加数
                    left++;
                } else { // 反之减少加数
                    right--;
                }
            }
        }
        return result;
    }
}
