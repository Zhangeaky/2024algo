package aleetcode.problem.leetcode226;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

@Solution(number = 226)
public class Solution20240517 {

    @SolutionMethod(description = "本质上应该是一个二叉树的后序遍历")
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        exchange(root.left, root.right);
        return root;
    }

    private void exchange(TreeNode left, TreeNode right) {

        // 递归终止条件
        if (left == null && right == null) {
            return;
        }

        // 先处理左节点
        if (left != null) {
            exchange(left.left, left.right);
        }

        // 后处理右节点
        if (right != null) {
            exchange(right.left, right.right);
        }

        // 处理当前节点
        TreeNode temp = left;
        left = right;
        right = temp;
    }

}
