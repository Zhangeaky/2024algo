package aleetcode.problem.leetcode78;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> resultList = new ArrayList<>();

    private List<Integer> path;


    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null ) {
            return resultList;
        }

        path = new ArrayList<>();

        for (int i=0; i<=nums.length; i++) {
            dfs(nums, i, 0);
        }

        return resultList;
    }

    private void dfs(int[] nums, int size, int beginIndex) {

        //递归终止条件一
        if (path.size() == size) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i=beginIndex; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, size, beginIndex+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

        Solution ss = new Solution();
        System.out.println(ss.subsets(new int[]{1, 2, 3}));
    }
}











