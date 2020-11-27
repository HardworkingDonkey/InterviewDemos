package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-028-实现strStr()
 * @since 2020.11.27 14:34
 */

public class LeetCode_028_StrStr {
    // 太久了 只超过20+%
//    public int strStr(String haystack, String needle) { // 干草堆里找针???
//        if (haystack == null || needle == null) {
//            return -1;
//        }
//        if (haystack.equals(needle) || needle.length() == 0) {
//            return 0;
//        }
//        for (int i = 0; i < haystack.length(); i++) {
//            // 在haystack中找出needle的首字母
//            if (haystack.charAt(i) != needle.charAt(0)) {
//                continue;
//            }
//            boolean flag = haystack.length() - i >= needle.length();
//            if (!flag) {
//                return -1;
//            }
//            for (int j = 0; j < needle.length(); j++) {
//                if (i + j < haystack.length() && haystack.charAt(i + j) != needle.charAt(j)) {
//                    flag = false;
//                    break;
//                }
//            }
//            // 代码来到这里时, 如果flag为true i指向第一个needle出现的位置
//            if (flag) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // L, n = len(needle), len(haystack)
    //
    //        if L == 0:
    //            return 0
    //
    //        start = 0
    //
    //        while start < n - L + 1:
    //            curr_len = 0
    //            while curr_len < L and haystack[start] == needle[curr_len]:
    //                start += 1
    //                curr_len += 1
    //            if curr_len == L:
    //                return start - L
    //            start = start - curr_len + 1
    //        return -1

    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        // 当needle为""时, 直接返回0
        if (nLen == 0) {
            return 0;
        }
        // 遍历haystack
        for (int i = 0; i < hLen - nLen + 1; ) {
            // curLen记录当前已成功匹配needle中的字符长度
            int curLen = 0;
            // 依次比较两个字符串的字符, 遇到不同的字符立刻跳出
            while (curLen < nLen && haystack.charAt(i) == needle.charAt(curLen)) {
                i++;
                curLen++;
            }
            // 如果成功匹配的长度等于needle的长度, haystack包含了needle
            if (curLen == nLen) {
                // 直接返回haystack的索引减去needle的长度
                return i - curLen;
            }
            // 匹配失败则重置索引为本轮起始索引 + 1
            i = i - curLen + 1;
        }
        return -1;
    }
}
