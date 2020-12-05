package com.donkey.interview.leetcode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-045-跳跃游戏II
 * @since 2020.12.04 10:21
 */

public class LeetCode_045_JumpGame {
    public int jump(int[] nums) {
        int step = 0;
        // 当前能选择的最远起跳点
        int maxEnd = 0;
        // 当前能跳到的最远距离
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // nums[i] + i 表示当前格子能跳的最远位置
            maxPosition = Math.max(maxPosition, nums[i] + i);
            // 如果当前位置是最远起跳点
            if (i == maxEnd) {
                step++;
                maxEnd = maxPosition;
            }
        }
        return step;
    }

}
