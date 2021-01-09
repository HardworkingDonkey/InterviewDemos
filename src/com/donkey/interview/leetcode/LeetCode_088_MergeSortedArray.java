package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-088-合并有序数组
 * @since 2021.01.09 17:12
 */

public class LeetCode_088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = nums1.length - 1;
        int i = m - 1, j = n - 1; // 分别指向nums1和nums2
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[insertIndex--] = nums1[i--];
            } else {
                nums1[insertIndex--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[insertIndex--] = nums2[j--];
        }
    }
}
