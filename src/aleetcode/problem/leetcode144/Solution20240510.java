package aleetcode.problem.leetcode144;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/description/">二叉树的前序遍历</a>
 */
@Solution
public class Solution20240510 {

    @SolutionMethod(description = "使用递归")
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        dfs(root, resultList);

        return resultList;
    }

    private void dfs(TreeNode node, List<Integer> resultList) {
        // 递归终止条件
        if (node == null) {
            return;
        }
        resultList.add(node.val);
        dfs(node.left, resultList);
        dfs(node.right, resultList);
    }
}
