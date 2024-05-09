package aleetcode.problem.leetcode94;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/">二叉树中序遍历</a>
 */
@Solution
public class Solution1 {

    @SolutionMethod
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        if (null == root) {
            return resultList;
        }

        traversal(root, resultList);

        return resultList;
    }

    private void traversal(TreeNode node, List<Integer> resultList) {

        if (node.left !=null) {
            traversal(node.left, resultList);
        }

        resultList.add(node.val);

        if (node.right != null) {
            traversal(node.right, resultList);
        }
    }
}
