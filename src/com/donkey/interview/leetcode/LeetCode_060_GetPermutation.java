package com.donkey.interview.leetcode;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-060-排序序列
 * @since 2020.12.11 0:09
 */

public class LeetCode_060_GetPermutation {
//    String result = "";
//    int count = 0;
//
//    public String getPermutation(int n, int k) {
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = i + 1;
//        }
//        Deque<Integer> path = new LinkedList<>();
//        boolean[] used = new boolean[n];
//        List<String> resultSet = new ArrayList<>();
//        dfs(nums, used, path, k, resultSet);
//        return result;
//    }
//
//    private void dfs(int[] nums, boolean[] used, Deque<Integer> path, int k, List<String> resultSet) {
//        if (count < k && path.size() == nums.length) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (Integer integer : path) {
//                stringBuilder.append(integer);
//            }
//            System.out.println(stringBuilder.toString());
//            resultSet.add(stringBuilder.toString());
//            count++;
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (!used[i]) {
//                    path.addLast(nums[i]);
//                    used[i] = true;
//                    dfs(nums, used, path, k, resultSet);
//                    path.removeLast();
//                    used[i] = false;
//                    if (count == k) {
//                        result = resultSet.get(count - 1);
//                        return;
//                    }
//                }
//            }
//        }
//    }

    int[] factorial;

    public String getPermutation(int n, int k) {
        StringBuilder path = new StringBuilder();

        calculateFactorial(n);
        boolean[] used = new boolean[n];

        dfs(n, k, used, path);

        return path.toString();
    }

    private void dfs(int n, int k, boolean[] used, StringBuilder path) {
        if (path.length() == n) {
            return;
        }
        int count = factorial[n - 1 - path.length()];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (count < k) {
                k -= count;
                continue;
            }
            path.append(i + 1);
            used[i] = true;
            dfs(n, k, used, path);
            return;
        }
    }

    /**
     * 计算出n的阶乘存到数组
     *
     * @param n 计算阶乘
     * @return void
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1; // 0! = 1
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
    }
}
