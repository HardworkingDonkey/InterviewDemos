package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.09
 * @Time 18:08
 * @Package PACKAGE_NAME
 * @Description 面试题5-替换空格
 */

public class ToOffer_05_ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int oriLength = s.length();
        // 遍历字符串统计空格数
        int spaceCount = 0;
        for (int i = 0; i < oriLength; i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        // 保存中间的新字符串
        char[] temp = new char[oriLength + 2 * spaceCount];
        int left = oriLength - 1;
        int right = temp.length - 1;
        while (left >= 0 && right >= 0 && left != right) {
            char curChar = s.charAt(left);
            if (curChar != ' ') {
                temp[right--] = curChar;
            } else {
                temp[right--] = '0';
                temp[right--] = '2';
                temp[right--] = '%';
            }
            left--;
        }
        // 将剩余字符加进去
        while (left >= 0 && right >= 0) {
            temp[right--] = s.charAt(left);
            left--;
        }
        return new String(temp);
    }
}
