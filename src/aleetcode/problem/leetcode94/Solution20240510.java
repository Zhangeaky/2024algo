package aleetcode.problem.leetcode94;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;

@Solution
public class Solution20240510 {

    @SolutionMethod(description = "递归")
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        dfs(root, resultList);

        return resultList;
    }

    private void dfs(TreeNode node, List<Integer> resultList) {

        //递归终止条件
        if (node == null) {
            return;
        }

        dfs(node.left, resultList);
        resultList.add(node.val);
        dfs(node.right, resultList);
    }

}
