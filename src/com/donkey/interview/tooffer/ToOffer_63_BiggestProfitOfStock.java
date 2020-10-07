package com.donkey.interview.tooffer;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.tooffer
 * @description 面试题63-股票的最大利润
 * @since 2020.10.07 20:46
 */

public class ToOffer_63_BiggestProfitOfStock {
    // 求最优解的过程是, 找出尽可能小的且位于"前面"的数, 并用后面的数减去前面的数, 保留最大值
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        for (int price : prices) {
            cost = Math.min(price, cost);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
