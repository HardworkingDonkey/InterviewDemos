package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-009 回文数
 * @since 2020.10.22 19:44
 */

public class LeetCode_009_IsPalindrome {
    // 时间: O(log n), 空间: O(1)
    public boolean isPalindrome(int x) {
        // 负数不可能是回文数
        // 如果最后一位是0, 回文数则第一位必须是0, 那就只有0
        // 如果x是负数, 或者x最后一位是0但x不是0, 则返回false
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        // revertedNum是x后半部分的逆转
        int revertedNum = 0;
        // 循环: x取出最后一位给revertedNum充当最后一位
        // 当x > revertedNum
        // 也就是 x 的位数多于revertedNum
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        // 如果x是回文数, 则
        // x为偶数时, 退出循环时x和revertedNum位数一致
        // x为奇数时, 退出循环时x比revertedNum少一位
        // 奇数的最中间一位不影响判断
        return x == revertedNum || x == revertedNum / 10;
    }
}
