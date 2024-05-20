package aleetcode.problem.leetcode110;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/description/">平衡二叉树</a>
 */
@Solution(number = 110)
public class Solution20240520 {

    @SolutionMethod(description = "递归法")
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return false;
        }

        int process = process(root);

        return process != -1;
    }

    /**
     *  当value == -1 则说明 node 节点的子树高度之差大于1，
     *  已经不是平衡二叉树了。
     * @param node node
     * @return value
     */
    public int process(TreeNode node) {

        //递归终止条件
        if (node == null) {
            return 0;
        }

        // 左 侧遍历
        int left = process(node.left);
        if (left == -1) {
            return -1;
        }

        // 右 侧遍历
        int right = process(node.right);
        if (right == -1) {
            return -1;
        }

        // 中间节点处理, 左右节点各自都是平衡的
        if (Math.abs(left-right) > 1) {
            return -1;
        }

        return 1+Math.max(left, right);
    }

}
