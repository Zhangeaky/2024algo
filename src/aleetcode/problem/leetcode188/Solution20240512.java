package aleetcode.problem.leetcode188;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/">买股票的最佳时机IV</a>
 */
@Solution
public class Solution20240512 {

    @SolutionMethod
    public int maxProfit(int k, int[] prices) {

        // 需要的状态细分, k==3为例:
        // 0第0次不持有
        // 1第1次持有
        // 2第1次不持有
        // 3第2次持有
        // 4第2次不持有
        // 5第3次持有
        // 6第3次不持有
        // 需要7中状态来描述 所有的情况

        // dp 数组的定义
        int[][] dp = new int[prices.length][2*k+1];
        dp[0][0] = 0;
        // dp 数组的初始化
        for (int j=1; j<=k; j++) {
            dp[0][2*j-1] = -prices[0];
        }

        for (int i=1; i<prices.length; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j=1; j<=k; j++) {
                // 第j次持有
                //   -延续前面的
                //   -今天买入，前面是第j-1次不持有
                dp[i][j*2-1] = Math.max(dp[i-1][j*2-1], dp[i-1][j*2-2] - prices[i]);

                // 第j次不持有
                //  延续前一天状态
                //  今天我卖出,前一天是j-1次持有
                dp[i][j*2] = Math.max(dp[i-1][j*2], dp[i-1][j*2-1] + prices[i]);
            }
        }

        // TODO: 2024/5/15 这个逻辑怎么确认 为甚么是这个 ？
        return dp[prices.length-1][2*k];
    }

    public static void main(String[] args) {
        Solution20240512 ss = new Solution20240512();
        System.out.println(ss.maxProfit(2, new int[]{2, 4, 1}));
    }

}
