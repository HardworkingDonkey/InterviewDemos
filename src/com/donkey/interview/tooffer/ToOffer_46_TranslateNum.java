package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题46-把数字翻译成字符串
 * @since 2020.09.28 19:17
 */

public class ToOffer_46_TranslateNum {
    // 0 -> 'a'
    // 1 -> 'b'
    // ...
    // 25 -> 'z'
    public int translateNum(int num) {
        // 如果最后两个数字翻译成字符, f(n) = f(n - 1) + f(n - 2)
        // 否则 f(n) = f(n - 1)
        String s = String.valueOf(num);
        if (s.length() == 1) {
            return 1;
        }
//        int[] dp = new int[s.length()];
//        dp[0] = 1;
//        dp[1] = isInRange(s, 1) ? 2 : 1;
//        for (int i = 2; i < s.length(); i++) {
//            dp[i] = dp[i - 1] + (isInRange(s, i) ? dp[i - 2] : 0);
//        }
//        return dp[s.length() - 1];
        int a = 1;
        int b = isInRange(s, 1) ? 2 : 1;
        int c = b;
        for (int i = 2; i < s.length(); i++) {
            c = b + (isInRange(s, i) ? a : 0);
            a = b;
            b = c;
        }
        return c;
    }

    public boolean isInRange(String s, int i) {
        s = s.substring(i - 1, i + 1);
        return s.compareTo("25") <= 0 && s.compareTo("10") >= 0;
    }
}
