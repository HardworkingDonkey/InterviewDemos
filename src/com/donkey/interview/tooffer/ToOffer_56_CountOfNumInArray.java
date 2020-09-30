package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题56-数组中数字出现的次数
 * @since 2020.09.30 13:19
 */

public class ToOffer_56_CountOfNumInArray {
    // 如果数组中只有一个只出现一次的数字, 其余都是出现两次
    // 那么整个数组的数字异或得到的结果就是这个数字
    // 因为成对出现的数字异或会变成0
    // 如果数组中有两个只出现一次的数字, 其余都是出现两次
    // 则把数组分成两部分, 每部分有一个只出现一次的数字
    public int[] singleNumbers(int[] nums) {
        int x = 0; // 0 ^ x = x
        // 将所有数进行异或, 最终结果等于那两个只出现一次的数的异或
        for (int num : nums) {
            x ^= num;
        }
        // 根据异或特性, 找出这两个数(二进制表示)从右到左第一个"不同"的位
        // 也就是找出上面异或结果从右到左第一个为1的位
        int div = 1;
        while ((div & x) == 0) {
            div <<= 1; // 左移一位
        }
        int a = 0;
        int b = 0;
        // 分组策略: 与div与运算结果为1的一组, 0的一组
        // 因为是根据两个只出现一次的数找出的"不同"的位, 所以这两个数必定分在不同组
        // 不同组的数异或得到结果就是只出现一次的数
        for (int num : nums) {
            if ((num & div) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
