package aleetcode.problem.leetcode213;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/description/">打家劫舍II</a>
 */
@Solution(number = 213)
public class Solution20240507 {


    @SolutionMethod
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] pre = new int[nums.length-1];
        int[] post = new int[nums.length-1];

        for (int i=0; i<nums.length-1; i++) {
            pre[i] = nums[i];
        }

        for (int i=1; i<nums.length; i++) {
            post[i-1] = nums[i];
        }

        Arrays.stream(pre).forEach(x -> System.out.print(x +" "));
        System.out.println();
        Arrays.stream(post).forEach(x -> System.out.print(x +" "));


        return Math.max(robOne(pre), robOne(post));
    }

    //198 抄过来
    private int robOne(int[] nums) {

        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i< nums.length; i++) {
            dp[i] = Math.max (dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {

        Solution20240507 ss = new Solution20240507();
        int rob = ss.rob(new int[]{1, 2, 1, 1});
        System.out.println(rob);
    }



}
