package com.donkey.interview.tooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题48-最长不含重复字符的子字符串
 * @since 2020.09.28 22:49
 */

public class ToOffer_48_LongestNoRepeatSubStr {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                // 更新左指针
                i = Math.max(map.get(ch), i);
                result = Math.max(result, j - i);
            }
            map.put(ch, j);
        }
        return result;
    }
}
