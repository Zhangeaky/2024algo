package aleetcode.problem.leetcode494;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/target-sum/description/">目标和</a>
 */
public class Solution20240410 {

    public int findTargetSumWays(int[] nums, int target) {

        if (nums == null || nums.length ==0) {
            return 0;
        }

        int sum = Arrays.stream(nums).reduce(0, Math::addExact);
        if (((target + sum) % 2) != 0) {
            return 0;
        }

        int weight = (target + sum) / 2;

        int[] dp = new int[weight+1];

        int count = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=weight; j>= nums[i] ; j--) {
                int origin = dp[j];
                int newValue = dp[j - nums[i]] + nums[i];
                if (newValue == weight ) {
                    count ++;
                }
                dp[j] = Math.max(origin, newValue);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Solution20240410 ss = new Solution20240410();
        System.out.println(ss.findTargetSumWays(new int[]{2, 2, 3, 5}, 2));
        System.out.println(ss.findTargetSumWays(new int[]{1, 2, 3}, 1));

    }
}
