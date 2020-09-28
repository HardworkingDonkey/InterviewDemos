package com.donkey.interview.tooffer;

import org.junit.Test;

import java.util.*;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题38-字符串的排列
 * @since 2020.09.27 23:43
 */

public class ToOffer_38_Permutations {
    boolean[] used;
    StringBuilder tmp = new StringBuilder();
    Set<String> res = new HashSet<>();

    public String[] permutation(String s) {
        if (s == null || "".equals(s)) {
            return new String[0];
        }
        int len = s.length();
        used = new boolean[len];
        permutation(s, len, 0);
        return res.toArray(new String[0]);
    }

    public void permutation(String s, int len, int depth) {
        // 如果深度 == 长度, 说明排列已经到了最后一位, 可以加入结果集
        if (depth == len) {
            res.add(tmp.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                tmp.append(s.charAt(i));
                used[i] = true;
                permutation(s, len, depth + 1);
                used[i] = false;
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("abc")));
    }
}
