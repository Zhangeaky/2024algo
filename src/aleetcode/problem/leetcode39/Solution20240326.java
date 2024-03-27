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
        // 这就是为什么这道题目会出现重复的原因。 开始不能始终为0；
        // 1. 组合问题不是排列问题。重复出现的组合方式 和是相同的没有意义。
        // 2. 选定第一个数字后，回溯会搜索出所有包含第一个数子的组合之和。
        // 3. 所以在选定第二个数字之后，第二层递归，不要再往前选择第一个数字了。否则就出现重复了。
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
        System.out.println(ss.combinationSum(new int[]{1, 2, 3}, 3));

    }
}
