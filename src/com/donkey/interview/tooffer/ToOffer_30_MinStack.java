package com.donkey.interview.tooffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题30-包含min函数的栈
 * @since 2020.09.24 14:55
 */

public class ToOffer_30_MinStack {
    static class MinStack {
        Deque<Integer> dataStack;
        Deque<Integer> minStack;

        public MinStack() {
            dataStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(x, minStack.element()));
            }
        }

        public void pop() {
            if (!dataStack.isEmpty()) {
                dataStack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (!dataStack.isEmpty()) {
                return dataStack.element();
            } else {
                return 0;
            }
        }

        public int min() {
            if (!minStack.isEmpty()) {
                return minStack.element();
            } else {
                return 0;
            }
        }
    }
}
