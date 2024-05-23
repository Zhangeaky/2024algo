package aleetcode.problem.leetcode152;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked">
 *     乘积最大子数组</a>
 */
@Solution(number = 152)
public class Solution20240506 {

    @SolutionMethod
    public int maxProduct(int[] nums) {

        if (nums == null) {
            return 0;
        }

        // dp数组的含义 下标为i的数前，连续最大乘积是dp[i]
        int[] dp = new int[nums.length+1];
        boolean continueFlag = true;
        dp[0] = nums[0];
        if (nums[0]*nums[1] > nums[1] && nums[0]*nums[1] > nums[0]) {
            dp[1] = nums[0]*nums[1];
            continueFlag = true;
        }

        if (nums[1] > nums[0] && nums[1]>nums[1]*nums[0]) {
            dp[1] = nums[0]*nums[1];
            continueFlag = true;
        }

        if (nums[0] > nums[1] && nums[0]>nums[1]*nums[0]) {
            dp[1] = nums[0];
            continueFlag = false;
        }

        for (int i=2; i<nums.length; i++) {
            int valueOne = dp[i-1];
            int valueTwo = dp[i-1]*nums[i];
            int valueThree = nums[i];

            if (continueFlag) {
                if (valueThree >= valueTwo && valueThree >= valueOne) {
                    dp[i] = valueThree;
                }

                if (valueTwo >= valueThree && valueTwo >= valueOne) {
                    dp[i] = dp[i-1]*nums[i];
                }

                if (valueOne >= valueTwo && valueOne >= valueThree) {
                    dp[i] = nums[i];
                    continueFlag = false;
                }

            } else {

                if (valueThree >= valueOne) {
                    dp[i] = valueThree;
                    continueFlag = true;
                }

                if (valueThree <= valueOne) {
                    dp[i] = valueOne;
                    continueFlag = false;
                }
            }
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        Solution20240506 ss = new Solution20240506();
        System.out.println(ss.maxProduct(new int[]{2, 3, -2, 4}));
    }

}
