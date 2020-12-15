package com.donkey.interview.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-067-二进制求和
 * @since 2020.12.13 20:59
 */

public class LeetCode_067_AddBinary {
//    public String addBinary(String a, String b) {
//        char[] sum = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)).toCharArray();
//        System.out.println(Arrays.toString(sum));
//        for (int i = sum.length - 1; i >= 1; i--) {
//            boolean carry = sum[i] >= '2';
//            if (carry) {
//                sum[i - 1]++;
//                sum[i] -= 2;
//            }
//        }
//        System.out.println(Arrays.toString(sum));
//        if (sum[0] >= '2') {
//            sum[0] -= 2;
//            StringBuilder stringBuilder = new StringBuilder(String.valueOf(sum));
//            stringBuilder.insert(0, "1");
//            return stringBuilder.toString();
//        }
//        return String.valueOf(sum);
//    }

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry; // 当前位的初始值为之前的进位
            // 当前位加上该位置的两个数
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            carry = sum / 2;
            stringBuilder.append(sum % 2);
        }
        if (carry > 0) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(addBinary("1", "11"));
    }
}
