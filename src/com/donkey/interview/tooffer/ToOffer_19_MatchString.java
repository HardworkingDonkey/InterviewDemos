package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.17
 * @Time 13:04
 * @Package com.donkey
 * @Description 面试题19-字符串匹配
 */

public class ToOffer_19_MatchString {
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null || p.length() == 0) {
//            return false;
//        }
//        return match(s, 0, p, 0);
//    }

    public boolean match(String s, int index_s, String p, int index_p) {
        // 如果越界则设为'\0'
        char cur_s = index_s < s.length() ? s.charAt(index_s) : '\0';
        char cur_p = index_p < p.length() ? p.charAt(index_p) : '\0';
        char next_p = index_p + 1 < p.length() ? p.charAt(index_p + 1) : '\0';
        // 两个索引刚好走到最后, 则说明完全匹配
        if (cur_s == '\0' && cur_p == '\0') {
            return true;
        }
        // 字符串的索引还没走完但是模式的索引已经走完, 则匹配失败
        if (cur_s != '\0' && cur_p == '\0') {
            return false;
        }
        if (next_p == '*') { // 如果下一个模式是"*"
            // 如果当前字符和模式匹配, 或者当前模式是'.'且字符未越界
            if (cur_s == cur_p || (cur_p == '.' && cur_s != '\0')) {
                return match(s, index_s + 1, p, index_p + 2) || // 匹配下一个模式
                        match(s, index_s + 1, p, index_p) || // 尝试匹配连续字符
                        match(s, index_s, p, index_p + 2); // 忽略"*"
            } else { // 忽略"*"
                return match(s, index_s, p, index_p + 2);
            }
        } // 如果下一个模式不是"*"
        if (cur_s == cur_p || (cur_p == '.' && cur_s != '\0')) {
            return match(s, index_s + 1, p, index_p + 1);
        }
        return false;
    }

    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
