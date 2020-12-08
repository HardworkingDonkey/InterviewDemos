package com.donkey.interview.leetcode;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-049-字母异位词分组
 * @since 2020.12.06 9:13
 */

public class LeetCode_049_GroupAnagrams {
    // 24%, 22%
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new LinkedList<>();
//        if (strs == null || strs.length == 0) {
//            return result;
//        }
//        // 记录每个字符串的字母出现次数
//        int[] counts = new int[26];
//        // 建立键为字母出现次数情况, 值为情况相同的字符串的列表
//        Map<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            // 遍历每个字符串前将计数数组清零
//            Arrays.fill(counts, 0);
//            // 遍历字符串的每个字符, 统计出现次数
//            for (char ch : str.toCharArray()) {
//                counts[ch - 'a']++;
//            }
//            StringBuilder stringBuilder = new StringBuilder();
//            // 拼接为哈希的键
//            for (int count : counts) {
//                stringBuilder.append("#").append(count);
//            }
//            String key = stringBuilder.toString();
//            // 不存在键时要创建新的List
//            if (!map.containsKey(key)) {
//                map.put(key, new LinkedList<>());
//            }
//            // 将计数情况相同的数放入map
//            map.get(key).add(str);
//        }
//        result.addAll(map.values());
//        return result;
//    }

    // 95%, 82%
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(); // 用ArrayList不要LinkedList
        }
        // 建立键为字母出现次数情况, 值为情况相同的字符串的列表
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); // 不要用Arrays.toString(chars), 太慢了
            // 不存在键时要创建新的List
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // 将计数情况相同的数放入map
            map.get(key).add(str);
        }

        // 不要用addAll(), 太慢了
        return new ArrayList<>(map.values());
    }
}
