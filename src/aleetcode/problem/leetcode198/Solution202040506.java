package aleetcode.problem.leetcode198;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">打家劫舍</a>
 */
@Solution(value = 198,
        name = "打家劫舍",
        link = "https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked")
public class Solution202040506 {

    @SolutionMethod(description = "打家劫舍", value = "01")
    public int rob(int[] nums) {

        if (nums == null) {
            return 0;
        }

        // dp数组的含义: 考虑到下标为第i个房子的情况下，偷到最多的钱为dp[i]元。
        int[] dp = new int[nums.length+1];

        //只有一间房子的时候，没有选择，只有偷的份儿
        dp[0] = nums[0];
        //有2间房子的时候，偷大的那个。
        dp[1] = Math.max(nums[0], nums[1]);

        // 递推公式

        // 遍历顺序
        for (int i=2; i< nums.length; i++) {
            // 选择偷第i座房子的时候，第i-1房子一定不能偷 所以是dp[i-2] + nums[i]
            // 选择不偷第i座房子的时候，从第i-1房开始推算 所以是dp[i-1]，i-1房子可以偷，也可以不偷。
            dp[i] = Math.max (dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length-1];

    }

    public static void main(String[] args) {

        Solution202040506 ss = new Solution202040506();
        System.out.println(ss.rob(new int[]{2, 1, 1, 2}));
    }
}
