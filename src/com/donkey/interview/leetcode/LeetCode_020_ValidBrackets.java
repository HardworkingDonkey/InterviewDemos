package com.donkey.interview.leetcode;

import java.util.LinkedList;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-020-有效的括号
 * @since 2020.10.28 17:48
 */

public class LeetCode_020_ValidBrackets {
    public boolean isValid(String s) {
        char[] letters = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char letter : letters) {
            // 如果是左括号, 入栈
            if (letter == '{' || letter == '[' || letter == '(') {
                stack.push(letter);
                // 如果是右括号, 弹出栈顶并比较
            } else if (letter == '}' || letter == ']' || letter == ')') {
                // 弹出栈顶
                Character top = stack.pollFirst();
                if (top == null || letter == '}' && top != '{' || letter == ']' && top != '[' || letter == ')' && top != '(') {
                    return false;
                }
            }
        }
        // 如果括号匹配正确, 则stack为空, 只要有左括号未弹出, 则说明括号匹配不正确
        return stack.isEmpty();
    }
}
