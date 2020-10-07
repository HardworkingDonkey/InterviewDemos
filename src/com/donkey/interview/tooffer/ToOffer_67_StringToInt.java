package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题67-把字符串转为整数
 * @since 2020.10.08 0:25
 */

public class ToOffer_67_StringToInt {
    public int strToInt(String str) {
        int res = 0, boundary = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0) {
            return 0;
        }
        // 跳过空字符
        while (str.charAt(i) == ' ') {
            if (++i == length) return 0;
        }
        // 判断第一个字符是否为正负
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        // 如果第一个字符是符号, 则索引i需要 + 1
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        for (; i < length; i++) {
            char ch = str.charAt(i);
            // 有非法字符
            if (ch < '0' || ch > '9') {
                break;
            }
            // 判断数值是否会越界
            // 如果 res > boundary(最大值/10)则说明这轮会越界
            // 如果刚好 = 最大值/10, 则再判断下一位
            // 如果大于7, 则 * 10再加上这一位后会越界
            if (res > boundary || res == boundary && ch > '7') {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 不越界则加上, ch - '0' 则将这一位字符转为数值
            res = res * 10 + ch - '0';
        }
        return res * sign;
    }
}
