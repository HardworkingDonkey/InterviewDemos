package com.donkey.interview.leetcode;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-044-通配符匹配
 * @since 2020.12.04 9:17
 */

public class LeetCode_044_WildcardMatch {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // 数组长度为字符长度 + 1是为了将字符为空这一情况也算进去
        // 也即dp[i][0]表示p为空, dp[0][j]表示s为空
        // dp[i][0]固定为 false, dp[0][j]当p前j个字符为 * 时为 true
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // dp[0][0]表示空字符匹配空字符
        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                // 如果此时p是通配符
                if (p.charAt(j - 1) == '*') {
                    // 则可以选择忽略通配符 dp[i][j - 1]
                    // 或者不忽略通配符 dp[i - 1][j]
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    // 如果s[i] == p[j]或p[j] == '?'
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    // 也就是当前s[i]和p[j]匹配一定成功, 只需要看前面的结果
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][pLen];
    }

    //    public boolean isMatch(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        dp[0][0] = true;
//        for (int i = 1; i <= n; ++i) {
//            if (p.charAt(i - 1) == '*') {
//                dp[0][i] = true;
//            } else {
//                break;
//            }
//        }
//        for (int i = 1; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                if (p.charAt(j - 1) == '*') {
//                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                }
//            }
//        }
//        return dp[m][n];
//    }
}

