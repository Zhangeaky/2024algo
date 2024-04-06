package aleetcode.problem.leetcode118;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle/?envType=study-plan-v2&envId=top-100-liked">杨辉三角形</a>
 */
public class Solution20240401 {

    /**
     * 第 n 行有n个数
     */
    public List<List<Integer>> generate(int numRows) {

        //1. 确定dp数组的下标和value
        // 下标是第 i 层  dp[i] 是 第i层的数
        List<List<Integer>> dp = new ArrayList<>(numRows);

        // 初始化
        dp.add(Arrays.asList(1));
        for (int row=1; row<numRows; row++) {

            List<Integer> thisRow = new ArrayList<>();
            dp.add(thisRow);

            for (int col=0; col<=row; col++) {
                if (col ==0 || col==row) {
                    thisRow.add(1);
                    continue;
                }
                //上一行
                Integer integer = dp.get(row - 1).get(col - 1) + dp.get(row - 1).get(col);
                thisRow.add(integer);
            }
        }

        return dp;
    }

    public static void main(String[] args) {

        Solution20240401 ss = new Solution20240401();
        ss.generate(6).stream().forEach(x -> System.out.println(x+"\n"));


    }

}
