package aleetcode.problem.leetcode377;

import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iv/">组合总和IV</a>
 */
public class Solution20240505 {

    @SolutionMethod(description = "使用动态规划")
    public int combinationSum4_(int[] nums, int target) {

        // 确定dp数组的含义: 和为i的组合数有dp[i]种
        int[] dp = new int[target+1];
        dp[0] = 1;
        // 先遍历背包 再遍历物品，物品会被多次重复遍历，所以会出现不同的排列。
        for (int i=1; i<=target; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i>=nums[j]) {
                    dp[i]+= dp[i-nums[j]];
                }
                System.out.println("dp数组打印:背包amount为:" + i + ";" + "dp[" + i + "]=" + dp[i]);
            }
        }
        return dp[target];
    }

    @SolutionMethod(description = "使用回溯, 内存还是不够的。")
    public int combinationSum4(int[] nums, int target) {

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, target, path, resultList);
        return resultList.size();
    }

    private void dfs(int[] nums, int target, List<Integer> path, List<List<Integer>> resultList) {

        //递归终止条件一
        if (target == 0 ) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        //单层递归
        for (int i=0; i<nums.length; i++) {
            if ((target-nums[i])<0) {
                continue;
            }
            target-=nums[i];
            path.add(nums[i]);
            dfs(nums, target, path, resultList);

            target+=nums[i];
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {
        Solution20240505 ss = new Solution20240505();
        System.out.println(ss.combinationSum4_(new int[]{3,1,2,4}, 4));
    }

}
