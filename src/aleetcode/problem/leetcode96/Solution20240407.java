package aleetcode.problem.leetcode96;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/">不同的搜索二叉树</a>
 */
public class Solution20240407 {

    public int numTrees(int n) {

        if (n == 0) {
            return 0;
        }

        // dp 数组初始化 dp[i] n=i 有个dp[i]棵二叉搜索树
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        return 0;
    }

}
