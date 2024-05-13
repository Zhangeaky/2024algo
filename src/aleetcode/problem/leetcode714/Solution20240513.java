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


        //状态定义 因为手续费的扣减 和卖出这个状态强相关。所以需要这个状态来。
        // 0 不持有
        // 1 持有股票
        // 2 卖出日
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = -fee;

        for (int i=1; i<prices.length; i++) {

            // 第i日 不持有,且不是卖出
            // - 与前一日保持一致
            // - 前一日卖出

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);

            // 第i日 持有股票
            // - 与前一日保持一致
            dp[i][1] = dp[i-1][1];


            // 第i日 卖出日



        }





    }
}
