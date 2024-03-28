package aleetcode.problem.leetcode78;

import java.util.ArrayList;
import java.util.List;

public class Solution20240328 {

    private List<List<Integer>> resultList;

    private List<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {

        resultList = new ArrayList<>();
        if (nums == null) {
            return null;
        }

        path = new ArrayList<>();

        for (int size=0; size <= nums.length; size++) {
            dfs(nums, size, 0);
        }
        return resultList;
    }

    // 自己个数
    private void dfs(int[] nums, int size, int begin) {

        // 递归终止条件
        if (size == path.size()) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i=begin; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, size, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution20240328 ss = new Solution20240328();
        List<List<Integer>> subsets = ss.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
