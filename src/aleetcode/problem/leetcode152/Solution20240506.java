package aleetcode.problem.leetcode152;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked">
 *     乘积最大子数组</a>
 */
@Solution
public class Solution20240506 {

    @SolutionMethod
    public int maxProduct(int[] nums) {

        if (nums == null) {
            return 0;
        }

        // dp数组的含义 下标为i的数前，连续最大乘积是dp[i]
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], Math.max(nums[1], nums[0]*nums[1]));

        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1]*nums[i], Math.max(dp[i-1], nums[i]));
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {

    }

}
