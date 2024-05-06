package aleetcode.problem.leetcode279;


import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/perfect-squares/">完全平方数</a>
 */
public class Solution20240505 {

    @SolutionMethod(description = "动态规划，完全背包")
    public int numSquares(int n) {

        // 1. dp 数组的含义: 和为i的 最少平方数是dp[i]
        int[] dp = new int[n+1];

        // 2. 初始化dp数组
        dp[0] = 1;

        // 3. 递归公式
        // 4. 遍历顺序
        for (int i=1; i<=n; i++) { //遍历背包
            for (int j=0; j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }


        return 0;
    }

}
