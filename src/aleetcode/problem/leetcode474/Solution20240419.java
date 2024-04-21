package aleetcode.problem.leetcode474;

import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/ones-and-zeroes/description/">一和零</a>
 */
public class Solution20240419 {
    static class Item {
        public String value;
        public int valueOfOne;
        public int valueOfZero;
        Item(String item) {
            this.value = item;
            this.valueOfOne = 0;
            this.valueOfZero = 0;
            for (int i=0; i<item.length(); i++) {
                if (item.charAt(i) == '1') {
                    valueOfOne++;
                }
                if (item.charAt(i) == '0') {
                    valueOfZero++;
                }
            }
        }
    }

    @SolutionMethod
    public int findMaxForm(String[] strs, int m, int n) {

        if (strs == null) {
            return 0;
        }
        Item[] items = new Item[strs.length];

        for (int i=0; i<strs.length; i++) {
            items[i] = new Item(strs[i]);
        }
        // dp 数组的含义，有m个0 n个1 的子集 最大有元素dp[i][j]个
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        for (Item item : items) {
            for (int i = m; i >= item.valueOfZero; i--) {
                for (int j = n; j >= item.valueOfOne; j--) {
                    dp[i][j] = Math.max(dp[i - item.valueOfZero][j - item.valueOfOne] + 1,
                            dp[i][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution20240419 ss = new Solution20240419();
        System.out.println(ss.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
