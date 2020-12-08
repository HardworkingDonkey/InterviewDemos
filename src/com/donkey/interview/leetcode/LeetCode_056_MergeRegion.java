package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-056-合并区间
 * @since 2020.12.08 9:27
 */

public class LeetCode_056_MergeRegion {
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // 20%, 50%
//    public int[][] merge(int[][] intervals) {
//        List<int[]> result = new ArrayList<>();
//        if (intervals == null || intervals.length == 0) {
//            return new int[0][];
//        }
//        // 根据首元素比较
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        for (int i = 0; i < intervals.length; i++) {
//            int left = intervals[i][0];
//            int right = intervals[i][1];
//            // 如果索引 < 长度 - 1 (防止i + 1越界)
//            // 且如果下一个区间的左边界 <= 当前右边界
//            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
//                // 合并右区间
//                right = Math.max(right, intervals[i + 1][1]);
//                i++;
//            }
//
//            result.add(new int[]{left, right});
//        }
//        return result.toArray(new int[0][]);
//    }

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        // 根据首元素比较
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (result.size() == 0 || result.get(result.size() -1)[1] < left) {
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.max(right, result.get(result.size() - 1)[1]);
            }
        }
        return result.toArray(new int[0][]);
    }
}
