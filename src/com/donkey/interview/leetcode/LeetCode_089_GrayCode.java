package com.donkey.interview.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-089-格雷码
 * @since 2021.01.09 18:54
 */

public class LeetCode_089_GrayCode {
//    public List<Integer> grayCode(int n) {
//        List<Integer> res = new ArrayList<>();
//        res.add(0);
//        int head = 1;
//        for (int i = 0; i < n; i++) {
//            for (int j = res.size() - 1; j >= 0; j--) {
//                res.add(head + res.get(j));
//            }
//            head <<= 1;
//        }
//        return res;
//    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0); // n = 0 时
        int head = 0b1;
        for (int i = 0; i < n; i++) {
            // 将上一轮的结果集逆序取出加上本轮的head
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(head + result.get(j));
            }
            head <<= 1;
        }
        return result;
    }
}
