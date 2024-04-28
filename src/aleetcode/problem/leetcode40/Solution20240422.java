package aleetcode.problem.leetcode40;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">组合总和II</a>
 */
public class Solution20240422 {

    private List<List<Integer>> resultList = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    private Map<Integer, Boolean> usedMap = new HashMap<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null) {
            return resultList;
        }

        dfs(candidates, target, 0);
        return resultList;
    }

    private void dfs(int[] nums, int target, int begin) {

        // 递归终止条件
        if (target == 0) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i=begin; i<nums.length; i++) {
            if (target<0) {
                return;
            }
            if (Optional.ofNullable(usedMap.get(nums[i])).orElse(false)) {
                continue;
            }
            path.add(nums[i]);
            target-=nums[i];
            usedMap.put(nums[i], true);
            dfs(nums, target, i+1);

            path.remove(path.size()-1);
            target+=nums[i];
        }

    }

    public static void main(String[] args) {

        Solution20240422 ss = new Solution20240422();
        System.out.println(ss.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));

    }
}
