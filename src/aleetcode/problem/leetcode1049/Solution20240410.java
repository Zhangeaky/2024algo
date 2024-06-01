package aleetcode.problem.leetcode1049;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/last-stone-weight-ii/description/">最后一块石头的重量II</a>
 */
@Solution
public class Solution20240410 {

    @SolutionMethod
    public int lastStoneWeightII(int[] stones) {
        //这道题其实没什么内容，难点在于你如何想通，
        //将石头分为两堆 尽量相等的
        int sum = Arrays.stream(stones).sum();

        //得到背包重量
        int target = sum/2;

        int[][] dp = new int[stones.length][target+1];
        // 初始化
        for (int j=0; j<=target; j++) {
            dp[0][j] = j > stones[0] ? stones[0] : 0;
        }

        // 先遍历物品
        for (int i=1; i<stones.length; i++) {
            for (int j=1; j<=target ;j++) {
                if (j < stones[i]) {
                    // 放不下
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]] + stones[i]);
                }
            }
        }
        int max = dp[stones.length-1][target];
        return Math.abs((sum - max)-max);
    }

    public static void main(String[] args) {
        Solution20240410 ss = new Solution20240410();
        System.out.println(ss.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(ss.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}
