package aleetcode.problem.leetcode518;

import aleetcode.problem.instrument.Solution;

@Solution
public class Solution20240507 {

    public int change(int amount, int[] coins) {

        // 凑成i元 有dp[i]种方法
        int[] dp = new int[amount+1];
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] += (dp[i-coins[j]]);
                }
            }
        }
        return dp[amount];
    }



}
