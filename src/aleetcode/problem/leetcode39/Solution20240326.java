package aleetcode.problem.leetcode39;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution20240326 {

    private List<List<Integer>> resultList;

    private List<Integer> solutions;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        resultList = new ArrayList<>();
        if (candidates == null) {
            return resultList;
        }
        solutions = new ArrayList<>();
        dfs(target, candidates);
        return resultList;
    }

    private void dfs(int target, int[] can) {

        // 递归终止条件 1
        if (target < 0) {
            return;
        }
        // 递归终止条件 2
        if (target == 0) {
            resultList.add(new ArrayList<>(solutions));
            return;
        }

        // 单层递归逻辑执行
        for (int i=0; i<can.length; i++) {
            solutions.add(can[i]);
            target-=can[i];
            dfs(target, can);

            solutions.remove(solutions.size()-1);
            target+=can[i];
        }
    }

    public static void main(String[] args) {

        Solution20240326 ss = new Solution20240326();
        System.out.println(ss.combinationSum(new int[]{1, 2, 3}, 5));

    }
}
