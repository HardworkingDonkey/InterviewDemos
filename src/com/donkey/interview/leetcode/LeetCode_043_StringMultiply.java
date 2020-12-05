package com.donkey.interview.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-042-字符串相乘
 * @since 2020.12.03 16:11
 */

public class LeetCode_043_StringMultiply {
    public String multiply(String num1, String num2) {
        // 如果有一个是0则返回0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                result[i + j + 1] += (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
            }
        }
        // 整理答案
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] %= 10;
        }
        // 逆序拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }
}
