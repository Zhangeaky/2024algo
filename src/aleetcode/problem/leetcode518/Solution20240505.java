package aleetcode.problem.leetcode518;

import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/description/">零钱兑换II</a>
 */
public class Solution20240505 {

    // 使用回溯算法可以做这道题 但是当数据量一大容易产生超时和内存超限的问题
    @SolutionMethod
    public int change_traverse(int amount, int[] coins) {

        if (coins == null || coins.length ==0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(amount, coins, path, resultList, 0);
        System.out.println(resultList);
        return resultList.size();
    }

    private void dfs(int currentAmount, int[] coins, List<Integer> path, List<List<Integer>> resultList, int begin) {

        // 递归终止条件一
        if (currentAmount == 0) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 单层递归逻辑
        for (int i=begin; i<coins.length; i++) {
            if ((currentAmount - coins[i]) < 0 ) {
                continue;
            }

            currentAmount -= coins[i];
            path.add(coins[i]);
            dfs(currentAmount, coins, path, resultList, i);

            currentAmount += coins[i];
            path.remove(path.size()-1);
        }
    }


    // 采用先遍历背包 后遍历物品的方式
    @SolutionMethod
    public int change(int amount, int[] coins) {

        if (coins == null || coins.length ==0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        //1.  dp 数组的含义，兑换币值大小为j的钱币，有dp[j]种组合方法
        int[] dp = new int[amount+1];

        //2. 初始化dp数组
        dp[0] = 1;

        //
        for (int i=1; i<=amount; i++) {
            for (int j=0; j< coins.length; j++) {
                if (coins[j] > i) {
                    continue;
                }
                dp[i] += dp[i-coins[j]];
                System.out.println("dp数组打印:背包amount为:" + i + ";" + "dp[" + i + "]=" + dp[i]);
            }
        }

        return dp[amount];
    }

    @SolutionMethod
    public int change_corr(int amount, int[] coins) {

        if (coins == null || coins.length ==0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        //1.  dp 数组的含义，兑换币值大小为j的钱币，有dp[j]种组合方法
        int[] dp = new int[amount+1];

        //2. 初始化dp数组
        dp[0] = 1;
        //3. 先遍历背包 后遍历物品
        for (int i=0; i<coins.length; i++) {
            // 这里使用j++ 还是j-- 是怎么看？
            // TODO: 2024/5/5 初步推断，如果在0 位置初始化了值，就从小到大遍历，反之。。。
            for (int j=coins[i]; j<=amount; j++) {
                dp[j] += dp[j-coins[i]];
                System.out.println("dp数组打印:背包amount为:" + i + ";" + "dp[" + i + "]=" + dp[i]);
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {

        Solution20240505 ss = new Solution20240505();
        //int i = ss.change_traverse(5, new int[]{1, 2, 5});
        //int i = ss.change_traverse(500, new int[]{3,5,7,8,9,10,11});
        System.out.println(ss.change_corr(5, new int[]{1, 2, 5}));
    }
}
