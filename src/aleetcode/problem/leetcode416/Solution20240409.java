package aleetcode.problem.leetcode416;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked">
 *     分割等和子集</a>
 */
public class Solution20240409 {

    public boolean canPartition(int[] nums) {

        if (nums == null) {
            return false;
        }

        int sum = Arrays.stream(nums).reduce(0, Math::addExact);

        if (sum % 2 != 0) {
            return false;
        }

        //1. 确定dp数组的含义
        // dp[i][j] 表示为nums数组下标为i的数字随意取只取一次 放入重量为j的背包中的最大值
        int [][] dp = new int[nums.length][sum/2+1];

        // 2. 初始化
        for (int i=0; i<nums.length; i++) {
            dp[i][0] = 0;
        }

        for (int j=0; j<=sum/2; j++) {
            if (nums[0] <= j) {
                dp[0][j] = nums[0];
            }
        }

        // 递推公式
        for (int i=1; i<nums.length; i++) {
            for (int j=1; j<=sum/2; j++) {
                // 这个版本有错误 因为这里 这里不需要判断 想清楚为什么？
                if (nums[i] + dp[i-1][j] > j) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], nums[i] + dp[i-1][j-nums[i]]);
            }
        }



        for (int[] ints : dp) {
            if (ints[sum/2] == sum/2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution20240409 ss = new Solution20240409();
        System.out.println(ss.canPartition(new int[]{1, 2, 3, 6,2,4,1,1}));
    }


}
