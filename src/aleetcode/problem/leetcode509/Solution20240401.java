package aleetcode.problem.leetcode509;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number/description/">斐波那契数</a>
 */
public class Solution20240401 {

    public int fib(int n) {

        // 因为fib数列只依赖于前两层的结果
        int[] dp = new int[2];

        // 初始化
        //dp[0] = 0;
        dp[1] = 1;

        if (n<2) {
            return dp[n];
        }

        int result = 0;
        for (int i=2; i<=n; i++) {
            result = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = result;
        }
        return result;

    }

}
