package aleetcode.problem.leetcode123;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/">买股票的最佳时机III</a>
 */
@Solution(number = 123)
public class Solution20240511 {

    // 怎么用动态规划的思路 将这个最多两次买卖交易抽象出来呢？

    @SolutionMethod
    public int maxProfit(int[] prices) {


        int[][] dp = new int[prices.length][4];
        // 第一次不持有
        dp[0][0] = 0;
        // 第一次持有
        dp[0][1] = -prices[0];
        // 第一次卖出
        dp[0][2] = 0;
        // 第二次持有
        dp[0][3] = -prices[0];
        // 第二次卖出
        dp[0][4] = 0;

        for (int i=1; i<prices.length; i++) {
            // 第i天 第一次持有
            // - 延续第一次的状态
            // - i-1 天是初始化状态，第i天买入
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);

            // 第i天 第一次卖出
            // - i-1 天也是第一次卖出
            // - i-1天是第1次持有 第i天卖出
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);

            // 第i天 第二次持有
            // - i-1 第二次持有
            // - i-1 第1次卖出 第i天买入
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);

            // 第i天 第二次卖出
            // - i-1 第二次卖出
            // - i-1 第二次持有 第i天卖出
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }

        return dp[prices.length-1][4];
    }
}
