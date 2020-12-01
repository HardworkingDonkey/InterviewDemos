package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-038-外观数列
 * @since 2020.12.01 8:46
 */

public class LeetCode_038_AppearanceArray {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 拿到上一层的字符串
        String pre = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        // 定义快慢指针,
        for (int i = 1, start = 0; i <= pre.length(); i++) {
            // 如果快指针越界, 或者遇到不同的字符
            if (i == pre.length() || pre.charAt(i) != pre.charAt(start)) {
                result.append(i - start).append(pre.charAt(start));
                start = i;
            }
        }
        return result.toString();
    }
}
