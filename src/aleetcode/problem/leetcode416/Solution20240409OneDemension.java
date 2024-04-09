package aleetcode.problem.leetcode416;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution20240409OneDemension {


    public boolean canPartition(int[] nums) {

        if (nums == null) {
            return false;
        }

        //省去双数判断
        int sum = Arrays.stream(nums).reduce(0, Math::addExact);
        if (sum%2 !=0 ) {
            return false;
        }
        int target = sum/2;
        int[] dp = new int[target+1];

        for (int i=0; i<nums.length; i++) {
            for (int j=sum/2;j>=nums[i];j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

    public static void main(String[] args) {
        Solution20240409OneDemension dd = new Solution20240409OneDemension();
        Solution20240409 ss = new Solution20240409();
        int[] input = {1, 2, 3, 6, 2, 4, 1, 1};
        System.out.println(dd.canPartition(input));

        System.out.println(ss.canPartition(input));
    }




}
