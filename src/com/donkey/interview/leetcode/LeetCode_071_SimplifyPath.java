package com.donkey.interview.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.leetcode
 * @description LeetCode-071-简化路径
 * @since 2020.12.14 21:32
 */

public class LeetCode_071_SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> queue = new LinkedList<>();
        for (String dir : dirs) {
            // 如果不为空字符(空字符则是因为分割了"//")
            if (dir.length() != 0) {
                // 如果是".."且队列不为空
                if ("..".equals(dir)) {
                    // 这里不能把队列判空放在同个if判断(可能导致将".."添加到队列)
                    if (!queue.isEmpty()) {
                        queue.removeLast();
                    }
                } else if (!".".equals(dir)) { // 除掉"."
                    queue.addLast(dir);
                }
            }
        }
        if (queue.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (String dir : queue) {
            result.append("/").append(dir);
        }
        return result.toString();
    }

}
