package com.donkey.interview.tooffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题59-滑动窗口的最大值
 * @since 2020.09.30 21:16
 */

public class ToOffer_59_MaxOfSlideWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        if (len == 0 || k == 0) {
//            return new int[]{};
//        }
//        Deque<Integer> queue = new LinkedList<>();
//        int[] result = new int[len - k + 1];
//        // 未形成窗口
//        for (int i = 0; i < k; i++) {
//            // 如果是第一个数, 直接把索引加进去
//            if (queue.isEmpty()) {
//                queue.addLast(i);
//            } else { // 如果
//                int head = nums[queue.getFirst()];
//                // 如果第一个元素比要加进去的元素小
//                if (head <= nums[i]) {
//                    // 弹出所有元素(因为后续这些元素不可能成为最大值)
//                    queue.clear();
//                    queue.addLast(i);
//                } else { // 如果第一个元素比要加进去的元素大
//                    // 则添加当前元素, 因为当前面的元素滑出窗口时, 当前元素可能成为最大值
//                    queue.addLast(i);
//                }
//            }
//        }
//        for (int i = k, j = 0; i < len; i++, j++) {
//            result[j] = nums[queue.getFirst()];
//        }
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        int left = 0; // 窗口左索引
        int right = k - 1; // 窗口右索引
        int max = -1; // 最大值索引
        int[] result = new int[len - k + 1];
        while (right < len) {
            // 当滑动窗口后max不在窗口内
            if (max < left) {
                max = left;
                // 遍历left到right, 找出最大值
                for (int i = left + 1; i <= right; i++) {
                    max = nums[max] < nums[i] ? i : max;
                }
            } else { // 当滑动窗口后max仍在窗口内, 只需要比较最后一个数
                max = nums[max] < nums[right] ? right : max;
            }
            result[left] = nums[max];
            left++;
            right++;
        }
        return result;
    }

    // 额外维护一个双端队列, 用来保存当前队列可能的最大值, 且是有序的, 首大尾小
    // 插入数据时, 将双端队列中所有小于value的尾部元素弹出, 将value存放于双端队列尾部
    // 弹出队首时, 需要判断双端队列的队首是否也是该值, 如果是则一起弹出
    class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>(); // 队列: 插入和删除
            deque = new LinkedList<>(); // 双端队列: 获取最大值
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.getFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            if (!deque.isEmpty() && deque.getFirst() < value) {
                    deque.clear();
            }
            // 将双端队列中所有小于value的尾部元素弹出
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.removeLast();
            }
            // 将该值存放于尾部
            deque.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int result = queue.poll();
            if (result == deque.getFirst()) {
                deque.removeFirst();
            }
            return result;
        }

    }
}
