package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-057-插入区间
 * @since 2020.12.09 23:42
 */

public class LeetCode_057_InsertRegion {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        // 将左边不重合的部分加入结果
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        int left = newInterval[0];
        int right = newInterval[1];
        // 将中间重合的部分加入结果
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            left = Math.min(left, intervals[i][0]);
            right = Math.max(right, intervals[i][1]);
            i++;
        }
        result.add(new int[]{left, right});
        // 将右边不重合的部分加入结果
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[0][]);
    }
}
