package com.donkey.interview.leetcode;

/**
 * @Author 刻苦驴
 * @Date 2020.05.06
 * @Time 16:16
 * @Package PACKAGE_NAME
 * @Description LeetCode(5)-最长回文子串
 */

public class LeetCode_005_LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int n = s.length();
        // 动态规划: dp[i][j]记录字符串从i到j索引位置的子串是否为回文
        // 动态的填充二维数组的值
        boolean[][] dp = new boolean[n][n];
        int left = 0, right = 0; // 记录最终答案的左右索引
        // 由于会比较到dp[i + 1][j - 1]的值
        // 所以i + 1的位置要比i先填, j - 1要比j先填
        // 所以i降序, j升序
        // 并且 i + 1 < n 且 i >= 0  所以 i 取值 [0, n - 1)
        // 同理 j 取值 [i + 1, n)
        // i从倒数第二个字符开始, i往字符首端移动
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true; // 长度 == 1 的子串一定为回文
            // j从i的下一个位置开始, 往字符串尾端移动
            for (int j = i + 1; j < n; j++) {
                //小于3是因为aba一定是回文
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
