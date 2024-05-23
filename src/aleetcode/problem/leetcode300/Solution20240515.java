package aleetcode.problem.leetcode300;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked">
 *     最长递增子序列</a>
 */
@Solution(number = 300)
public class Solution20240515 {

    @SolutionMethod
    public int lengthOfLIS(int[] nums) {

        // nums数组中，从0-i 范围内的 最长递增子序列的长度为 dp[i]
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i=1; i<nums.length; i++) {
            dp[i] = dp[i-1];
            // TODO: 2024/5/20 这里为什么是从0 --> i-1遍历还没完全理解
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] +1, dp[i]);
                }
            }
        }

        return  dp[nums.length-1];
    }

    public static void main(String[] args) {
        Solution20240515 ss = new Solution20240515();

        System.out.println(ss.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

}
