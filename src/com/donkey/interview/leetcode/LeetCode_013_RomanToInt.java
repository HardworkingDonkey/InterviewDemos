package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-013-罗马数字转整数
 * @since 2020.10.24 9:41
 */

public class LeetCode_013_RomanToInt {
//    public int romanToInt(String s) {
//        // 定义数组让阿拉伯数字和罗马数字一一对应
//        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        int result = 0;
//        // 遍历罗马数字, 每次尝试匹配最大的罗马数字
//        // i是罗马数字的索引, j是字符串s的索引
//        for (int i = 0, j = 0; i < symbols.length; i++) {
//            String symbol = symbols[i];
//            // 判断字符串当前索引所指的一个或两个字符能否匹配当前罗马数字
//            while ((j + symbol.length() <= s.length()) && symbol.equals(s.substring(j, j + symbol.length()))) {
//                // 可以匹配的话
//                result += values[i]; // 结果加上对应的整数
//                j += symbol.length(); // 移动字符串索引
//            }
//        }
//        return result;
//    }

    public int romanToInt(String s) {
        // 根据规律可知, 罗马数字中, 小数位于大数左边表示减, 在右边表示加
        // 如 IV = -1 + 5 = 4, VI = 5 + 1 = 6
        int result = 0;
        // 得到前一个数
        int pre = getInt(s.charAt(0));
        // 遍历字符串
        for (int i = 1; i < s.length(); i++) {
            // 得到当前数
            int cur = getInt(s.charAt(i));
            // 如果前一个数比当前小, 表示减去
            if (pre < cur) {
                result -= pre;
            } else { // 否则加上
                result += pre;
            }
            // 记得重置"前一个数"
            pre = cur;
        }
        // 别忘了加上最后一个数
        return result + pre;
    }

    public int getInt(char roman) {
        switch (roman) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }
}
