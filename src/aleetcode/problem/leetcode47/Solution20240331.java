package aleetcode.problem.leetcode47;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/">全排列II</a>
 */
public class Solution20240331 {


    private List<List<Integer>> resultList;

    private List<Integer> path;

    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        resultList = new ArrayList<>();
        if (nums == null) {
            return resultList;
        }

        path = new ArrayList<>();
        used = new boolean[nums.length];


        return resultList;
    }

    private void dfs(int[] nums) {

        //递归终止条件
        if (path.size() == nums.length) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {

            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i]=true;
            dfs(nums);

            path.remove(path.size()-1);
            used[i]=false;

        }

    }


    }
