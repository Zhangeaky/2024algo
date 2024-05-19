package aleetcode.problem.leetcode111;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/">二叉树最小深度</a>
 */

@Solution(number = 111)
public class Solution20240519 {

    @SolutionMethod(description = "自己的写法" +
            "当树编程一个链表节点的时候，如何处理 不是很清晰" + "" +
            "看了解答之后发现，其实是在于处理左右节点是否为空的问题上的差异。")
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return depthCompare(root, 0);
    }

    private int depthCompare(TreeNode node, int depth) {

        // 递归终止条件，当前节点为空了，那么深度和上一层传递进来的保持一致。
        if (node == null) {
            return depth;
        }

        depth++;

        if (node.left == null && node.right!=null) {
            return depthCompare(node.right, depth);
        }

        if (node.left != null && node.right ==null) {
            return depthCompare(node.left, depth);
        }

        int leftDepth = depthCompare(node.left, depth);

        int rightDepth = depthCompare(node.right, depth);

        return Math.min(leftDepth, rightDepth);

    }

}
