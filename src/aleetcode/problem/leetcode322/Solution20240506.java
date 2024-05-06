package aleetcode.problem.leetcode322;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

@Solution
public class Solution20240506 {
    @SolutionMethod
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }

        if (amount == 0) {
            return -1;
        }

        int[] dp = new int[amount+1];
        dp[0] = 0;

        for (int i=1; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<coins.length; i++) {
            for (int j=0; j<=amount; j++) {
                if (j>=coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution20240506 ss = new Solution20240506();
        System.out.println(ss.coinChange(new int[]{1, 2, 5}, 11));
    }
}
