package aleetcode.problem.leetcode343;

public class Solution20240406 {

    public int integerBreak(int n) {

        int [] dp = new int[n+1];

        dp[2] = 1;

        for (int i=3; i<=n; i++) {
            for (int j=1; j<=i/2; j++) {
                dp[i] = Math.max(j*(i-j), Math.max(j*dp[i-j], dp[i]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution20240406 ss = new Solution20240406();
        System.out.println(ss.integerBreak(10));
    }
}
