package aleetcode.problem.leetcode46;

import java.util.ArrayList;
import java.util.List;
public class Solution20240325 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null) {
            return resultList;
        }

        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, used, path, resultList);

        return resultList;
    }

    private void dfs(int index, int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> resultList) {

        // 递归终止条件
        if (path.size() == nums.length) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 从输入中取数
        for (int i=0; i<nums.length; i++) {
            // 使用过了就跳过
            if (used[i]) {
                continue;
            }

            // 没有使用改过则放入path中 并标记使用
            used[i] = true;
            path.add(nums[i]);
            dfs(index+1, nums, used, path, resultList);

            // 回撤
            path.remove(index);
            // 这里回撤是指索引是什么非常关键，是一个理解点。 不知道这里传什么就是没有理解这个算法。
            used[index] = false;
        }
    }




    public static void main(String[] args) {

        int[] input = {1, 2, 3};

        Solution20240325 ss = new Solution20240325();
        List<List<Integer>> permute = ss.permute(input);
        System.out.println(permute);
    }
}
