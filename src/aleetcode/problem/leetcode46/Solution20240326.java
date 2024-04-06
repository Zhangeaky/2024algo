package aleetcode.problem.leetcode46;

import java.util.ArrayList;
import java.util.List;

public class Solution20240326 {

    private List<Integer> path;

    private boolean[] used;

    private List<List<Integer>> resultList;

    public List<List<Integer>> permute(int[] nums) {

        resultList = new ArrayList<>();

        if (nums == null) {
            return resultList;
        }

        path = new ArrayList<>(nums.length);
        used = new boolean[nums.length];

        dfs(nums);

        return resultList;

    }

    private void dfs(int[] nums) {

        //递归终止条件
        if (nums.length == path.size()) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 单层递归
        for (int i = 0; i <= nums.length - 1; i++) {
            // nums数组的第i个元素已经在路径中
            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            dfs(nums);

            path.remove(path.size() - 1);
            used[i] = false;

        }
    }

    public static void main(String[] args) {
        Solution20240326 ss = new Solution20240326();
        System.out.println(ss.permute(new int[]{1, 1, 0}));
    }
}

