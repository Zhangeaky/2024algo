package aleetcode.problem.leetcode322;

import aleetcode.problem.instrument.SolutionMethod;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/">零钱兑换</a>
 */
public class Solution20240505 {

    @SolutionMethod(description = "动态规划", number = 322)
    public int coinChange(int[] coins, int amount) {

        // dp数组的含义是: 兑换i面值的钱币，最少需要dp[i]个钱币。
        int[] dp = new int[amount+1];

        Arrays.fill(coins, Integer.MAX_VALUE);
        // 初始化
        // TODO: 2024/5/6 这里为什么从1 开始呢？
        for (int j=1; j<=amount; j++) {
            for (int i=0; i<coins.length; i++) {
                // TODO: 2024/5/6 这里为什么要加一个初始值判断？？ 
                if (j>=coins[i] && dp[i-coins[j]]!=Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }

        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution20240505 ss = new Solution20240505();
        System.out.println(ss.coinChange(new int[]{2}, 3));
    }
}
