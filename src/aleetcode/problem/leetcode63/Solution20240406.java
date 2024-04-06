package aleetcode.problem.leetcode63;


/**
 * <a href="https://leetcode.cn/problems/unique-paths-ii/description/">不同路径II</a>
 */
public class Solution20240406 {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i=1; i<m; i++) {
            if (obstacleGrid[i][0] == 1 || obstacleGrid[i-1][0] == 1) {
                dp[i][0] = 0;
                continue;
            }

            dp[i][0] = dp[i-1][0];
        }

        for (int j=1; j<n; j++) {
            if (obstacleGrid[0][j] == 1 || obstacleGrid[0][j-1] == 1) {
                dp[0][j] = 0;
                continue;
            }

            dp[0][j] = dp[0][j-1];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

//                // 如果左边有障碍
//                if (obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] == 0) {
//                    dp[i][j] = dp[i-1][j];
//                    System.out.println("i="+ i +","+"j=" +j+ " " +dp[i][j]);
//                    continue;
//                }
//
//                // 如果上面有障碍
//                if (obstacleGrid[i-1][j] == 0) {
//                    dp[i][j] = dp[i][j-1];
//                    System.out.println("i="+ i +","+"j=" +j+ " " +dp[i][j]);
//                    continue;
//                }

//                // 如果上面边有障碍
//                if (obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] == 1) {
//                    dp[i][j] = 0;
//                    System.out.println("i="+ i +","+"j=" +j+ " " +dp[i][j]);
//                    continue;
//                }

                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                System.out.println("i="+ i +","+"j=" +j+ " " +dp[i][j]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution20240406 ss = new Solution20240406();

        int[][] case1 = new int[][]{{0,0,0},{0,1,0},{0,0,0}};

        int[][] case2 = new int[][]{{0,1},{0,0}};

        System.out.println(ss.uniquePathsWithObstacles(case1));
    }
}
