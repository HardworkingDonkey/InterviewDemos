package com.donkey.interview.leetcode;

/**
 * @Author 刻苦驴
 * @Date 2020.05.06
 * @Time 17:13
 * @Package PACKAGE_NAME
 * @Description LeetCode(6)-Z字形变换
 */

public class LeetCode_006_Z_Convert {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int a, j; // a是一个辅助变量, j是要追加到sb中的字符的索引
        for (int i = 0; i < numRows; ++i) {
            a = 0;
            j = i; // 每一行的第一个字符的索引刚好是行索引
            while (true) {
                if (j < s.length()) {
                    sb.append(s.charAt(j));
                } else break;
                if ((a ^= 1) == 1) {
                    // numRows - i - 1 == 0 则 i 为最后一行, i = n - 1
                    j += 2 * ((numRows - i - 1) == 0 ? i : numRows - i - 1);
                } else {
                    // i == 0 为第一行, n - i - 1 = n - 1
                    j += 2 * (i == 0 ? numRows - i - 1 : i);
                }
            }
        }
        return sb.toString();
    }
}
