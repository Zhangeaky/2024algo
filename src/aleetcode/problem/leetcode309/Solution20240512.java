package aleetcode.problem.leetcode309;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">
 *     买卖股票的最佳时机(冷冻期)</a>
 */
@Solution
public class Solution20240512 {

    @SolutionMethod
    public int maxProfit(int[] prices) {

        // ONE 明确dp数组的含义
        // 解题的关键是在引入冷冻期后  如何正确的抽象出整个过程中 所包含的完整状态。
        // 1. 持有股票 (买入日 + 持有期)
        // 2. 卖出日
        // 3. 冷冻期
        // 4. 不持有
        // 对比I题目，增加了卖出日这个状态。因为不持有股票这个状态被"冷冻期"这个状态给分割了。
        int[][] dp = new int[prices.length][4];

        // TWO 初始化dp数组
        // 持有股票 收益
        dp[0][0] = -prices[0];
        // 卖出日 收益
        dp[0][1] = 0;
        // 冷冻期 这里第一天根本不可能是冷冻期，所以怎么初始化需要和递推公式一起看
        dp[0][2] = 0;
        // 第0天 没有任何交易
        dp[0][3] = 0;

        System.out.println("第" + 0 + "天 " + dp[0][0] + "="+ dp[0][1] + "=" + dp[0][2] + "="+
                dp[0][3]);
        // 0持有股票 (买入日 + 持有期)
        // 1卖出日
        // 2冷冻期
        // 3不持有
        for (int i=1; i<prices.length; i++) {

            // 第i天 持有股票
            //  - 延续前一天状况
            //  - 第i天 买入
            //       - 第i-1天是不持有
            //       - 第i-1天是冷冻期
            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][2] - prices[i]), dp[i-1][3] - prices[i]);

            // 第i天 为卖出日
            //  - i-1 是持有股票
            dp[i][1] = dp[i-1][0] + prices[i];

            // 第i天 冷冻期
            //  - i-1 是卖出日
            dp[i][2] = dp[i-1][1];

            // 第i天 不持有
            //  - i-1 是冷冻期
            //  - i-1 是不持有 保持前一天装填
            dp[i][3] = Math.max(dp[i-1][2], dp[i-1][3]);

            System.out.println("第" + i + "天 " + dp[i][0] + "="+ dp[i][1] + "=" + dp[i][2] + "="+
                    dp[i][3]);
        }

        return Math.max(dp[prices.length-1][0],  Math.max(Math.max(dp[prices.length-1][2], dp[prices.length-1][3]), dp[prices.length-1][1]));
    }

    public static void main(String[] args) {
        Solution20240512 ss = new Solution20240512();
        System.out.println(ss.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

}
