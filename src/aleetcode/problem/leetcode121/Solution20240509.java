package aleetcode.problem.leetcode121;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">买股票的最佳时机I</a>
 */
@Solution
public class Solution20240509 {

    private int gross = 0;

    @SolutionMethod(description = "回溯")
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        dfs(prices, new ArrayList<>(), 0);
        return gross;
    }

    private void dfs(int[] prices, List<Integer> path, int beginIndex) {

        // 递归终止条件
        if (path.size() == 2) {
            if ((path.get(1) - path.get(0)) > gross) {
                gross = (path.get(1) - path.get(0));
                System.out.println(path);
            }
            return;
        }

        for(int i=beginIndex; i<prices.length; i++) {
            if (!path.isEmpty()) {
                if (- path.get(0) + prices[i] < 0) {
                    continue;
                }
            }
            path.add(prices[i]);
            dfs(prices, path, beginIndex+1);
            path.remove(path.size()-1);
        }
    }


    @SolutionMethod(description = "动态规划")
    public int maxProfit_dp(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        //1. dp 数组含义: 第i天 持有股票的 收益为 dp[i][1]
        //             第i天 不持有股票的 收益为 dp[i][0]
        int[][] dp = new int[prices.length][2];

        //2. 初始化 第0天不持股 0元
        dp[0][0] = 0;
        // 第0天 持股 -prices[0] 元
        dp[0][1] = -prices[0];

        //3. 遍历数组
        for (int i=1; i<prices.length; i++) {
            //第i天 持股的手头收益计算
                // 第一种情况，前一天就已经持股了, 这个时候"昨天持股，今天持股"手头钱不变
                // 第二种情况，第i天买入的 昨天没持股，今天才买，那就是 -prices[i] 因为只能买卖一次，所以没买的时候一定是0元。
                // 所以买了之后 资产就变成了 -prices[i]
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);

            //第i天 不持股的手头收益计算
                //第一种情况，前一天不持股了, 第i天也不买 手头钱不变
                // 第二种情, 前一天持股， 第i天卖掉, 今天的收益就是 昨天的钱 加上今天卖掉股票拿到的钱
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
        }

        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }
    public static void main(String[] args) {
        Solution20240509 ss = new Solution20240509();
        System.out.println(ss.maxProfit_dp(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
