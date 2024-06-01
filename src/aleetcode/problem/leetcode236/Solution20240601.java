package aleetcode.problem.leetcode236;

import aleetcode.problem.leetcode94.TreeNode;

public class Solution20240601 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        TreeNode leftSide = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSide = lowestCommonAncestor(root.right, p, q);

        // 因为题目说了不会有节点相同，所以使用引用比较和值比较都是可以的
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if (leftSide == null && rightSide == null) {
            return null;
        }

        if (leftSide == null && rightSide != null) {
            return rightSide;
        }

        if (leftSide != null && rightSide == null) {
            return leftSide;
        }

        // 左右都不为空 当前节点就是公共祖先。
        return root;
    }
}
