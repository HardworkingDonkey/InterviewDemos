package com.donkey.interview.leetcode;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-017-电话号码的字母组合
 * @since 2020.10.27 22:19
 */

public class LeetCode_017_LetterCombinations {
    // 33%, 33%
//    public List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0) {
//            return new LinkedList<>();
//        }
//        String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        List<String> result = new LinkedList<>();
//        result.add("");
//        // 遍历每个数字
//        for (int i = 0; i < digits.length(); i++) {
//            // 获取当前数字所对应的字母
//            String chars = map[digits.charAt(i) - '0'];
//            // 将队列中现有的字符取出
//            int size = result.size();
//            for (int j = 0; j < size; j++) {
//                // 取出当前队列中的首个字母
//                String head = result.remove(0);
//                // 遍历对应的每个字母, 队首拼接每个字母
//                for (int k = 0; k < chars.length(); k++) {
//                    result.add(head + chars.charAt(k));
//                }
//            }
//        }
//        return result;
//    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

//    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer buffer) {
//        if (index == digits.length()) {
//            combinations.add(buffer.toString());
//        } else {
//            String chars = phoneMap.get(digits.charAt(index));
//            for (int i = 0; i < chars.length(); i++) {
//                buffer.append(chars.charAt(i));
//                backtrack(combinations, phoneMap, digits, index + 1, buffer);
//                buffer.deleteCharAt(index);
//            }
//        }
//    }

    /**
     * @param combinations 结果集
     * @param phoneMap     映射关系
     * @param digits       指定字符串
     * @param index        索引
     * @param combination  当前结果
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 如果当前匹配到字符串最后一位
        if (index == digits.length()) {
            // 添加结果并回溯
            combinations.add(combination.toString());
        } else {
            // 取出当前索引指向的数字
            char digit = digits.charAt(index);
            // 取出该数字所映射的字符串
            String letters = phoneMap.get(digit);
            // 遍历字符串
            for (int i = 0; i < letters.length(); i++) {
                // 当前结果追加该字符, 并递归, 索引+1
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 回溯之后将当前结果的索引指向的字符删去
                combination.deleteCharAt(index);
            }
        }
    }
}
