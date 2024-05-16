package aleetcode.problem.leetcode343;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

@Solution(number = 343)
public class Solution20240517 {

    @SolutionMethod
    public int integerBreak(int n) {

        // dp 数组的含义  i拆分成的两个最大整数的乘积最大为 dp[i]
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        // TODO: 2024/5/17 这题其实是一个错误的初始化，但是碰巧对了。 因为这样计算碰巧dp[2]也等于1
        // 正确的做法是 dp[0] dp[1] 是无法初始化的 从dp[2] = 1 开始初始化，i=3开始计算。
        for (int i=2; i<=n; i++) {
            for (int j=1; j<i; j++) {

                // Max(dp[i], dp[i-j]*j, j(i-j))
                dp[i] = Math.max(j*(i-j), Math.max(dp[i], dp[i-j]*j));
            }
        }

        return dp[n];
    }


}
