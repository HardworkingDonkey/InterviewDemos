package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.15
 * @Time 22:21
 * @Package PACKAGE_NAME
 * @Description 面试题11-旋转数组的最小数
 */

public class ToOffer_11_MinInRotateArray {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int length = numbers.length;
        int left = 0, right = length - 1, mid;
        // 检查左边的数是否大于等于右边的数
        while (numbers[left] >= numbers[right]) {
            // 如果两个索引相邻, 则最小数一定在右边
            if (right - left == 1) {
                return numbers[right];
            }
            mid = (left + right) / 2;
            // 当左索引的数和右索引的数和中间索引的数相等
            // 此时无法知道最小数位于哪个半区, 只能顺序查找
            if (numbers[left] == numbers[right] && numbers[left] == numbers[mid]) {
                return minInOrder(numbers, left, right);
            }
            // 如果左边的数比中间小, 则说明left到mid的区间的数是递增的
            // 所以最小数不在这个范围, 将范围缩小(左索引赋值为中间)
            if (numbers[left] <= numbers[mid]) {
                left = mid;
            }
            // 同理, 右边的数大于中间, 则mid到right的区间的数是递增的
            // 最小数不在这个范围内, 将范围缩小(右索引赋值为中间)
            else if (numbers[right] >= numbers[mid]) {
                right = mid;
            }
        }
        // 根本没进去循环, 说明整个数组是递增的
        return numbers[0];
    }

    // 顺序查找的方法
    public int minInOrder(int[] nums, int left, int right) {
        // 现将结果设定为第一个数
        int result = nums[left];
        for (int i = left + 1; i <= right; i++) {
            // 找到第一个比result小的数就赋值然后返回
            if (result > nums[i]) {
                result = nums[i];
                break;
            }
        }
        return result;
    }
}
