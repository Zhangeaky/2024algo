package aleetcode.problem.leetcode343;

/**
 * <a href="https://leetcode.cn/problems/integer-break/">整数拆分</a>
 */
public class Solution20240406 {

    public int integerBreak(int n) {

        // 确定dp 数组的含义，数字i拆分出的最大乘积是dp[i]
        int [] dp = new int[n+1];
        // 0 1 都拆不了，没有任何意义
        dp[2] = 1;

        for (int i=3; i<=n; i++) {
            // 这里的j 取成 i/2 很巧秒 比较笨拙的办法是取 j<i
            for (int j=1; j<=i/2; j++) {

                //说明1:  j*(i-j) 拆两个数相乘的所有情况，以i=5 为例:
                // j=1, 1*4;
                // j=2, 2*3;
                // j>2 就不必了，因为和前面的重复了。

                // 说明2: j*dp[i-j], dp[i-j] 表示的数字拆成了至少2个数，j*dp[i-j] 拆成的个数至少为3，dp[i-j]*j就是dp[i] 拆成3个数以上的最大值。
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
