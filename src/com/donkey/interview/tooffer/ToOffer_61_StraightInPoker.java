package com.donkey.interview.tooffer;

import java.util.HashSet;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题61-扑克牌中的顺子
 * @since 2020.10.07 17:27
 */

public class ToOffer_61_StraightInPoker {
    public boolean isStraight(int[] nums) {
        // 除了0之外没有重复的数字
        // 最大值 - 最小值 < 5
        HashSet<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }
}
