package com.donkey.interview.leetcode;

import java.util.HashMap;

/**
 * @Author 刻苦驴
 * @Date 2020.05.02
 * @Time 10:20
 * @Package PACKAGE_NAME
 * @Description LeetCode(1)-两数之和
 */

public class LeetCode_001_TwoSum {
    //    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) { // 如果当前map包含当前元素的键
//                // 说明前面已经遍历过其互补值, 且通过
//                return new int[] {map.get(nums[i]), i};
//            }
//            // map中保存的键值对是: {当前数组元素互补值: 当前数组索引}
//            map.put(target - nums[i], i); // 将当前数组元素的"互补值"作为键, 元素下标索引作为值
//        }
//        return new int[0];
//    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {i, map.get(nums[i])};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
