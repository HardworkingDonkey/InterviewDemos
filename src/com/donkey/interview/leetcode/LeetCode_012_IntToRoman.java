package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-012-整数转罗马数字
 * @since 2020.10.24 9:19
 */

public class LeetCode_012_IntToRoman {
    public String intToRoman(int num) {
        // 定义数组让阿拉伯数字和罗马数字一一对应
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        // 贪心算法: 每次都取当前最优解
        // 让num先从可能匹配的最大数1000开始, 匹配完再匹逐次匹配更小的
        for (int i = 0; i < values.length; i++) {
            // 只要num >= 当前想要匹配的数
            while (num >= values[i]) {
                // 就让num减掉该匹配的数
                num -= values[i];
                // 并且结果字符串拼接上对应罗马数字
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
}
