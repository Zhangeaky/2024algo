package aleetcode.problem.leetcode279;


import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/perfect-squares/">完全平方数</a>
 */
@Solution(number = 279)
public class Solution20240505 {

    @SolutionMethod(number = 279, description = "动态规划，完全背包")
    public int numSquares(int n) {

        // 1. dp 数组的含义: 和为i的 最少平方数是dp[i]
        int[] dp = new int[n+1];

        // 2. 初始化dp数组，因为在递推公式这里为了不让前面的值将后面的值干扰 所以需要将非零值初始化成一个最大值。
        dp[0] = 0;

        for (int i=1; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 3. 递归公式
        // 4. 遍历顺序
        for (int i=0; i<=n; i++) { //遍历背包
            //这个牛逼 要看看自己怎么想到, 以及j的开头和结尾怎么取值 范围这些都要想通
            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        Solution20240505 ss = new Solution20240505();
        System.out.println(ss.numSquares(12));

    }

}
