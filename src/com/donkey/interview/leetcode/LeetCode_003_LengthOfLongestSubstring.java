package com.donkey.interview.leetcode;

import java.util.HashSet;

/**
 * @Author 刻苦驴
 * @Date 2020.05.04
 * @Time 13:52
 * @Package PACKAGE_NAME
 * @Description LeetCode(3)-无重复字符的最长子串
 */

public class LeetCode_003_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0, j = 0; // 滑动窗口左右索引
        while (j < s.length()) {
            char c = s.charAt(j); // 取出当前右边界所指元素
            if (!set.contains(c)) { // 不存在与set中
                set.add(c);
                System.out.println(set);
            } else { // 存在于set中时
                // 从左边界开始往右挨个扫描并删除
                // 直到左边界指向与此时右边界所指元素重复的元素
                while (s.charAt(i) != c) {
                    set.remove(s.charAt(i));
                    System.out.println(set);
                    i++;
                }
                // 然后再跳过重复的元素
                i++;
            }
            j++;
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }
}
