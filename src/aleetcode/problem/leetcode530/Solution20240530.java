package aleetcode.problem.leetcode530;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

@Solution
public class Solution20240530 {


    private TreeNode pre;

    private int min = Integer.MAX_VALUE;


    @SolutionMethod("用前后指针记录")
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return min;
    }

    private void dfs(TreeNode curr) {

        if (curr == null) {
            return;
        }

        dfs(curr.left);

        // 初始化逻辑
        if (pre != null) {
            int diff = Math.abs(pre.val - curr.val);
            min = Math.min(diff, min);
        }
        // 更新迭代
        pre = curr;

        // 右子树
        dfs(curr.right);

    }
}
