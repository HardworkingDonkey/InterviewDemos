package com.donkey.interview.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-084-柱状图中最大的矩形
 * @since 2020.12.22 22:00
 */

public class LeetCode_084_LargestRectangleArea {
//    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        // 固定高度, 求宽度
//        // 存储每一个高度对应的能往左往右伸展的宽度
//        int[] left = new int[n]; // 左边界
//        int[] right = new int[n]; // 右边界
//        Arrays.fill(right, n);
//        Deque<Integer> stack = new LinkedList<>();
//        for (int i = 0; i < n; ++i) {
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                right[stack.peek()] = i;
//                stack.pop();
//            }
//            left[i] = (stack.isEmpty() ? -1 : stack.peek());
//            stack.push(i);
//        }
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
//        }
//        return ans;
//    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 固定高度, 求宽度
        // 存储每一个高度对应的能往左往右伸展的宽度
        int[] left = new int[n]; // 左边界
        int[] right = new int[n]; // 右边界
        Arrays.fill(right, n);
        // 栈底 -> 栈顶
        //  小  ->  大
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                // 当栈顶元素比当前元素大时
                // 说明栈顶元素找到了右边第一个比它小的元素, 于是就是它的右边界了
                right[stack.peek()] = i;
                stack.pop();
            }
            // 当栈为空时, 说明当前元素是目前遍历过的元素中最小的, 所以左边界就是最左边
            // 当栈不为空时, 则栈顶元素比当前元素小, 是它的左边界
            // 因为比当前元素大的都被弹出栈了
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
