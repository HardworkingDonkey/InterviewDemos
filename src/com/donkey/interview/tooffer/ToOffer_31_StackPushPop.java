package com.donkey.interview.tooffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题31-栈的压入、弹出序列
 * @since 2020.09.24 16:47
 */

public class ToOffer_31_StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int popIndex = 0;
        // 当pushed栈顶不是popped的栈顶时, 将pushed压入辅助栈
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.element() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
