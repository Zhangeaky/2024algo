package aleetcode.problem.leetcode62;


/**
 * <a href="https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=top-100-liked">不同路径</a>
 */
public class Solution20240406 {

    public int uniquePaths(int m, int n) {

        if ( m <=0 || n <=0 ) {
            return 0;
        }

        // 机器人走到 (i,j)位置有多少种方法
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {

                if (i==0 && j==0) {
                    continue;
                }

                if (i==0) {
                    dp[i][j] = dp[i][j-1];
                    System.out.println("i="+ i +","+"j=" +j+ " " +dp[i][j]);
                    continue;
                }

                if (j==0) {
                    dp[i][j] = dp[i-1][j];
                    System.out.println("i="+ i +","+"j=" +j+ " " +dp[i][j]);
                    continue;
                }

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                System.out.println("i="+ i +","+"j=" +j+ " " +dp[i][j]);

            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        Solution20240406 ss = new Solution20240406();
        System.out.println(ss.uniquePaths(3, 7));

    }

}
