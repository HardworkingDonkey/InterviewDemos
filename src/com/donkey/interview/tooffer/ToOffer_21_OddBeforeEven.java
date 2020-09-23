package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题21-调整数组的奇数位于偶数前
 * @since 2020.09.22 13:00
 */

public class ToOffer_21_OddBeforeEven {
    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        // 定义两个索引, 左索引找出偶数, 右索引找出奇数
        int i = 0;
        int j = len - 1;
        // 两个索引相遇时说明左边全是奇数, 右边全是偶数
        while (i < j) {
            // 如果左索引的数是奇数
            if ((nums[i] & 0x1) == 1) {
                i++; // 索引右移, 跳过本轮
                continue;
            }
            // 如果右索引的数是偶数
            if ((nums[j] & 0x1) == 0) {
                j--; // 索引左移, 跳过本轮
                continue;
            }
            // 代码走到这里时, i索引肯定是偶数, j索引肯定是奇数, 所以交换
            swap(nums, i, j);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
