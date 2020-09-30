package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题58-翻转单词顺序
 * @since 2020.09.30 20:23
 */

public class ToOffer_58_TurnWordsOrder {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
//        s = s.trim();
//        int i = s.length() - 1;
//        int j = i;
//        StringBuilder result = new StringBuilder();
//        while (i >= 0) {
//        找出空格
//            while (i >= 0 && s.charAt(i) != ' ') {
//                i--;
//            }
//            result.append(s, i + 1, j + 1).append(" ");
//            while (i >= 0 && s.charAt(i) == ' ') {
//                i--;
//            }
//            j = i;
//        }
//        return result.toString().trim();
    }

    public String reverseLeftWords(String s, int n) {
//        char[] chars = s.toCharArray();
//        turn(chars, 0, chars.length - 1);
//        turn(chars, 0, chars.length - 1 - n);
//        turn(chars, chars.length - n, chars.length - 1);
//        return new String(chars);
        return s.substring(n) + s.substring(0, n);
    }

    public void turn(char[] s, int i, int j) {
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    public void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
