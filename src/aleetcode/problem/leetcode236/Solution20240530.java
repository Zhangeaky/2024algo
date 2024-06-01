package aleetcode.problem.leetcode236;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/">二叉树的公共祖先</a>
 */

@Solution
public class Solution20240530 {


    @SolutionMethod
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);


        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        if (left != null && right == null) {
            return left;
        }

        if (left == null && right != null) {
            return right;
        }

        throw new RuntimeException("");
    }
}
