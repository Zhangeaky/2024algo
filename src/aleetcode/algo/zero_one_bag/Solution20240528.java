package aleetcode.algo.zero_one_bag;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

@Solution
public class Solution20240528 {

    @SolutionMethod("")
    public int practice(int weight, int[] value, int[] weights) {


        int[][] dp = new int[value.length][weight+1];

        for (int j=0; j<=weight; j++) {
            dp[0][j] =  j >= weights[0]? value[0] : 0;
        }

        // 先遍历背包，后遍历物品
        for (int i=0; i<=weight; i++) {
            for (int j=1; j<value.length ; j++) {
                if (weights[j]-i>0) {
                    dp[j][i] = dp[j-1][i];
                } else {
                    dp[j][i] = Math.max(dp[j-1][i-weights[j]] + value[j], dp[j-1][i]);
                }
            }
        }

        return dp[value.length-1][weight];
    }

    public int practice_(int weight, int[] value, int[] weights) {


        int[][] dp = new int[value.length][weight+1];

        for (int j=0; j<=weight; j++) {
            dp[0][j] =  j >= weights[0]? value[0] : 0;
        }

        // 先遍历背包，后遍历物品
        for (int i=1; i< value.length; i++) {
            for (int j=1; j<=weight ; j++) {
                if (weights[i]-j>0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-weights[i]] + value[i], dp[i-1][j]);
                }
            }
        }

        return dp[value.length-1][weight];
    }

    public static void main(String[] args) {

        Solution20240528 ss = new Solution20240528();
        System.out.println(ss.practice_(4, new int[]{15, 20, 30}, new int[]{1, 3, 4}));

    }
}
