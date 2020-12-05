package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-042-接雨水
 * @since 2020.12.03 14:29
 */

public class LeetCode_042_ReceiveRainwater {
    // 12%, 70%   O(n^2) O(1)
//    public int trap(int[] height) {
//        int result = 0;
//        // 最左最右肯定不会有水, 直接遍历区间[1, height.length - 2]
//        for (int i = 1; i < height.length - 1; i++) {
//            int leftHighest = height[i - 1];
//            // 找出当前列的左边最高的列
//            for (int j = i - 2; j >= 0; j--) {
//                if (height[j] > leftHighest) {
//                    leftHighest = height[j];
//                }
//            }
//            // 如果左边最高的列小于等于当前列, 则当前列不可能有雨水
//            if (leftHighest <= height[i]) {
//                continue;
//            }
//            int rightHighest = height[i + 1];
//            // 找出当前列的右边最高的列
//            for (int j = i + 2; j < height.length; j++) {
//                if (height[j] > rightHighest) {
//                    rightHighest = height[j];
//                }
//            }
//            // 如果右边最高的列小于等于当前列, 则当前列不可能有雨水
//            if (rightHighest <= height[i]) {
//                continue;
//            }
//            result += (Math.min(leftHighest, rightHighest)) - height[i];
//        }
//        return result;
//    }

    public int trap(int[] height) {
        int result = 0;
        // 用两个数组保存每一列的最高左列和最高右列
        int[] leftHighest = new int[height.length];
        int[] rightHighest = new int[height.length];
        // 找出每一列的左边最高的列高度
        // 注意最左最右肯定没有雨水, 所以遍历区间[1, height.length - 2]
        for (int i = 1; i < height.length - 1; i++) {
            // 第i列的左边最高的列 = MAX(第i-1列的左边最高的列, 第i-1列)
            leftHighest[i] = Math.max(leftHighest[i - 1], height[i - 1]);
        }
        // 找出每一列的右边最高的列高度
        for (int i = height.length - 2; i >= 0; i--) {
            // 第i列的右边最高的列 = MAX(第i+1列的右边最高的列, 第i+1列)
            rightHighest[i] = Math.max(rightHighest[i + 1], height[i + 1]);
        }
        // 统计
        for (int i = 1; i < height.length - 1; i++) {
            // 找出最高左列和最高右列中低的一列
            int min = Math.min(leftHighest[i], rightHighest[i]);
            // 如果该列高于当前列, 则计算高度差并累加
            if (min > height[i]) {
                result += min - height[i];
            }
        }
        return result;
    }
}
