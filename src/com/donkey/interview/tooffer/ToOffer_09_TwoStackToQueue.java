package com.donkey.interview.tooffer;

import java.util.Stack;

/**
 * @Author 刻苦驴
 * @Date 2020.09.14
 * @Time 11:30
 * @Package PACKAGE_NAME
 * @Description 面试题9-用两个栈实现队列
 */

public class ToOffer_09_TwoStackToQueue {
    class CQueue {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            a.push(value);
        }

        public int deleteHead() {
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            if (b.isEmpty()) {
                return -1;
            }
            return b.pop();
        }
    }
}
