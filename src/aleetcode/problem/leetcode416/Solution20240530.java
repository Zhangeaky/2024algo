package aleetcode.problem.leetcode416;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.Arrays;

@Solution
public class Solution20240530 {

    @SolutionMethod
    public boolean canPartition(int[] nums) {

        if (nums == null) {
            return false;
        }

        // 计算数组 先
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum/2;

        // 转化为背包问题：
        // 背包的重量为target 物品是nums 他们重量是数子本身，价值也是。当装满背包时，存在等和子集。
        int[][] dp = new int[nums.length][target+1];

        // 初始化
        for (int j=0 ; j<= target; j++) {
            dp[0][j] =  nums[0]>j ? 0 : nums[0];
        }

        // 遍历顺序
        for (int i=1; i< nums.length; i++) {
            for (int j=1; j<=target; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
                }
            }
        }

        return dp[nums.length-1][target] == target;
    }
}
