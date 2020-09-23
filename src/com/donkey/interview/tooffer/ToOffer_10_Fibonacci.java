package com.donkey.interview.tooffer;

import org.junit.Test;

/**
 * @Author 刻苦驴
 * @Date 2020.09.14
 * @Time 12:22
 * @Package PACKAGE_NAME
 * @Description 面试题10-斐波那契数列
 */

public class ToOffer_10_Fibonacci {
    public int fib(int n) {
        if (n <= 1) { // 0, 1, 1, 2, 3, 5
            return n;
        }
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

//    @Test
    public void numWays() {
        int n = 5;
        if (n <= 2) {
            System.out.println(n);
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        System.out.println(result);
//        return result;
    }
}
