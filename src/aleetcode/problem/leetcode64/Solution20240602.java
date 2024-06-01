package aleetcode.problem.leetcode64;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked">
 *     最小路径和</a>
 */
@Solution
public class Solution20240602 {


    @SolutionMethod
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        //1. dp 数组的含义: 走到i,j 位置最小路径和为dp[i][j]
        int[][] dp = new int[grid.length][grid[0].length];

        //2. 递推公式 根据题目给出的走法，走到[i][j]位置只有两种可能
        // - 从[i-1][j]往下走一格
        // - 从[i][j-1]往右走一格

        //3. 初始化 第一行和第一列只有一种方法得到因此可以先初始化
        int firstLineSum = 0;
        for (int j=0; j< grid[0].length; j++) {
            firstLineSum += grid[0][j];
            dp[0][j] = firstLineSum;
        }

        int firstColSum = 0;
        for (int i=0; i< grid.length; i++) {
            firstColSum += grid[i][0];
            dp[i][0] = firstColSum;
        }

        for (int i=1; i< grid.length; i++) {
            for (int j=1; j< grid[0].length; j++) {
                int upperMin = dp[i-1][j] + grid[i][j];
                int leftMin = dp[i][j-1] + grid[i][j];
                dp[i][j] = Math.min(upperMin, leftMin);
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        Solution20240602 ss = new Solution20240602();
        System.out.println(ss.minPathSum(new int[][]
                {
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                }));

        System.out.println(ss.minPathSum(new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6}
                }));
    }

}
