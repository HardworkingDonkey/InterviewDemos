package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题66-构建乘积数组
 * @since 2020.10.07 22:01
 */

public class ToOffer_66_BuildProductArray {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[]{};
        }
        int[] result = new int[a.length];
        result[0] = 1;
        for (int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            result[i] *= tmp;
        }
        return result;
    }
}
