package aleetcode.problem.leetcode701;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/">
 *     二叉搜索树中的插入操作</a>
 */
@Solution
public class Solution20240601 {

    @SolutionMethod
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        insert(root, val);
        return root;
    }

    private void insert(TreeNode node, int val) {

        if (node == null) {
            return;
        }

        if (node.val < val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insert(node.right, val);
            }
        }

        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insert(node.left, val);
            }
        }

    }

}
