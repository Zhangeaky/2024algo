package aleetcode.problem.leetcode145;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/">二叉树后序遍历</a>
 */

@Solution
public class Solution20240510 {

    @SolutionMethod
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        dfs(root, resultList);
        return resultList;
    }

    public void dfs(TreeNode node, List<Integer> resultList) {
        // 递归终止条件
        if (node == null) {
            return;
        }
        dfs(node.left, resultList);
        dfs(node.right, resultList);
        resultList.add(node.val);
    }
}
