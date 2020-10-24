package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-011-盛水最多的容器
 * @since 2020.10.24 8:39
 */

public class LeetCode_011_MaxArea {
    public int maxArea(int[] height) {
        // 双指针位于最左和最右的垂线
        int i = 0, j = height.length - 1, area = 0;
        // 双指针向中间移动
        // 1. 每次移动双指针对应垂线中短的一条, 因为"短板效应"容积只取决于最短的木板
        // 移动长边的话, 只能减小距离不能提高水位线, 容积只会变小
        // 2. 当双指针未重合
        while (i < j) {
            // 短板效应, 容积 = 短边 * 距离
            // 并且往中间移动短的边, 保留最大面积
            area = height[i] < height[j] ? Math.max(height[i] * (j - i++), area) : Math.max(height[j] * (j-- - i), area);
        }
        return area;
    }
}
