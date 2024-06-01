package aleetcode.problem.leetcode543;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">
 *     二叉树的最大直径</a>
 */
@Solution
public class Solution20240327 {

    private int max = 0;

    @SolutionMethod
    public int diameterOfBinaryTree(TreeNode root) {

        traversal(root);
        return max;
    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int i = traversal(node.left);
        int j = traversal(node.right);
        max = Math.max(max, i+j);
        return Math.max(i, j) +1;
    }
}
