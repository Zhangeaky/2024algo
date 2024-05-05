package aleetcode.problem.leetcode518;

import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/description/">零钱兑换II</a>
 */
public class Solution20240505 {




    // 使用回溯算法可以做这道题
    @SolutionMethod
    public int change_traverse(int amount, int[] coins) {

        if (coins == null || coins.length ==0) {
            return 0;
        }

        if (amount == 0) {
            return 0;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(amount, coins, path, resultList);
        System.out.println(resultList);
        return resultList.size();
    }

    private void dfs(int currentAmount, int[] coins, List<Integer> path, List<List<Integer>> resultList) {

        // 递归终止条件一
        if (currentAmount == 0) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 单层递归逻辑
        for (int i=0; i<coins.length; i++) {
            if ((currentAmount - coins[i]) < 0 ) {
                continue;
            }

            currentAmount -= coins[i];
            path.add(coins[i]);
            dfs(currentAmount, coins, path, resultList);

            currentAmount += coins[i];
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

        Solution20240505 ss = new Solution20240505();
        int i = ss.change_traverse(5, new int[]{1, 2, 5});
        System.out.println(i);

    }


}
