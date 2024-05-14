package aleetcode.problem.leetcode714;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 *<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">
 *     买卖股票的最佳时机，含手续费</a>
 */
@Solution(number = 714)
public class Solution20240513 {

    @SolutionMethod(description = "")
    public int maxProfit(int[] prices, int fee) {

        // 0 不持有
        // 1 持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i=1; i<prices.length; i++) {

            // 第i日 不持有
            // - 与前一日保持一致
            // - 今日卖出
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);

            // 第i日 持有股票
            // - 与前一日保持一致
            // - 今日买入
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }

    public static void main(String[] args) {

        Solution20240513 ss = new Solution20240513();
        System.out.println(ss.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(ss.maxProfit(new int[]{1,3,7,5,10,3}, 3));

    }
}
