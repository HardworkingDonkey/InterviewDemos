package com.donkey.interview.tooffer;

import java.util.HashMap;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题50-第一个只出现一次的字符
 * @since 2020.09.29 13:27
 */

public class ToOffer_50_FirstOnceChar {
    public char firstUniqChar(String s) {
//        HashMap<Character, Boolean> map = new HashMap<>();
//        char[] chars = s.toCharArray();
//        for (char ch : chars) {
//            map.put(ch, !map.containsKey(ch));
//        }
//        for (char ch : chars) {
//            if (map.get(ch)) {
//                return ch;
//            }
//        }
//        return ' ';
        // ASCII码 256个
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            count[ch]++;
        }
        for (char ch : chars) {
            if (count[ch] == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
