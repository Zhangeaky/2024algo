package aleetcode.problem.leetcode188;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/">买股票的最佳时机IV</a>
 */
@Solution
public class Solution20240512 {

    @SolutionMethod
    public int maxProfit(int k, int[] prices) {

        // dp 数组的定义
        int[][] dp = new int[prices.length][2*k];

        for (int i=0; i<prices.length; i++) {
            // 不持有股票的收益
            dp[i][0] = 0;
        }


        return 0;
    }

}
