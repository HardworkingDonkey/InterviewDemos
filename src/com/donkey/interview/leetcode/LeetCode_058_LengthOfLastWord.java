package com.donkey.interview.leetcode;

import org.junit.Test;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-058-最后一个单词的长度
 * @since 2020.12.09 23:13
 */

public class LeetCode_058_LengthOfLastWord {
//    public int lengthOfLastWord(String s) {
//        String[] strings = s.split(" ");
//        if (strings.length == 0) {
//            return 0;
//        }
//        return strings[strings.length - 1].length();
//    }

    public int lengthOfLastWord(String s) {
        // 从后往前遍历
        int result = 0;
        int i = s.length() - 1;
        // 跳过最末尾的空格
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            // 遇到空格跳出
            if (s.charAt(i) == ' ') {
                break;
            }
            result++;
        }
        return result;
    }

    @Test
    public void test() {
        lengthOfLastWord(" ");
    }
}
