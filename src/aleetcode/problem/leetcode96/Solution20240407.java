package aleetcode.problem.leetcode96;

import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.instrument.Tester;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/">不同的搜索二叉树</a>
 */
public class Solution20240407 {

    @SolutionMethod
    public int numTrees(int n) {

        if (n == 0) {
            return 0;
        }
        //1. 确定DP数组的含义 dp[i] i作为BST头节点时，有dp[i]种形状。
        int[] dp = new int[n+1];

        //2. dp 数组初始化
        dp[0] = 1;
        //dp[1] = 1; 这个不需要初始化，否则每次累加都会加上这个1
        // 理解这循环很重要
        for (int i=1; i<=n; i++) {
            // 理解这的j是什么意思，内层循环式是什么意思十分重要。
            for (int j=1; j<=i; j++ ) {
                // 当BST的头节点定了之后，左右各多少个节点就已经定了。
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution20240407 ss = new Solution20240407();
        System.out.println(ss.numTrees(3));
    }
}
