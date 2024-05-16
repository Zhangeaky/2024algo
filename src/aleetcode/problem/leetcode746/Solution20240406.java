package aleetcode.problem.leetcode746;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">使用最少的步数爬楼梯</a>
 */
@Solution(number = 746)
public class Solution20240406 {

    @SolutionMethod(description = "")
    public int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) {
            return 0;
        }

        // 因为爬到顶楼需要爬到数组最后一个元素之后的一个位置
        int[] dp = new int[cost.length+1];
        // 初始化 dp数组 难点
        dp[0] =0;
        dp[1] =0;

        // 递推公式 遍历顺序
        for (int i=2; i<cost.length+1; i++) {
            dp[i] = Math.min ((dp[i-2] + cost[i-2]), dp[i-1] + cost[i-1]);
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {

        Solution20240406 ss =new Solution20240406();
        System.out.println(ss.minCostClimbingStairs(new int[]{10, 15, 20}));

    }
}
