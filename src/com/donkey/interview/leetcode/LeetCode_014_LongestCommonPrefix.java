package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-014-公共最长前缀
 * @since 2020.10.24 10:24
 */

public class LeetCode_014_LongestCommonPrefix {
    // 时间复杂度O(mn), m为字符串长度, n为字符串个数
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 将字符串数组"纵向扫描": ↓↓↓↓↓
        // leetcode
        // leet
        // lees
        StringBuilder result = new StringBuilder();
        // i是纵向扫描的横坐标
        // j是纵向扫描的纵坐标
        for (int i = 0; i < strs[0].length(); i++) {
            // 用第一个字符串的索引i所指的字符作为要比较的字符
            char cur = strs[0].charAt(i);
            // 从上往下扫描字符串中同一列的字符
            for (int j = 1; j < strs.length; j++) {
                // 如果横坐标超过了某一个字符串的长度, 返回
                if (i >= strs[j].length()) {
                    return result.toString();
                }
                // 如果当前字符串对应索引i的字符不为cur, 返回
                if (strs[j].charAt(i) != cur) {
                    return result.toString();
                }
            }
            // 当走到这里时说明i这一列的字符全部相同, 追加字符
            result.append(cur);
        }
        return result.toString();
    }
}
