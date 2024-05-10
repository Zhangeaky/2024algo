package aleetcode.problem.leetcode122;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">买股票的最佳时机II</a>
 */
@Solution(number = 122)
public class Solution20240510 {

    @SolutionMethod
    public int maxProfit(int[] prices) {



        int[][] dp = new int[prices.length][2];
        // 第0天不购入
        dp[0][0] = 0;
        // 第0天买入
        dp[0][1] = -prices[0];

        for (int i=1; i<prices.length; i++) {
            // 第i天不占有股票
            //  - 第一种，把前一天的卖了。
            //  - 第二种，之前就没买，一直不变。
            dp[i][0] = Math.max(dp[i-1][1]+prices[i], dp[i-1][0]);

            // 第i天占有股票
            //  第一情况， 之前没买今天买
            //  第二种情况 之前就买了，今天保持
            //  第三种情况，把之前的卖了，买了今天的。
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);

        }

        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);

    }
}
