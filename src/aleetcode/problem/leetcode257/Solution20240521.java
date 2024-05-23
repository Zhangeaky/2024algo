package aleetcode.problem.leetcode257;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-paths/description/"></a>
 */
@Solution(number = 257)
public class Solution20240521 {

    @SolutionMethod(description = "")
    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<String> resultList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();


        dfs(root, path, resultList);

        return resultList;

    }

    private void dfs(TreeNode node, List<Integer> path, List<String> resultList) {

        // 递归终止条件 叶子节点
        if (node.left == null && node.right == null) {
            path.add(node.val);
            resultList.add(cal(path));
            return;
        }

        path.add(node.val);

        // 递归逻辑
        if (node.left != null) {
            dfs(node.left, path, resultList);
            path.remove(path.size()-1);
        }

        if (node.right != null) {
            dfs(node.right, path, resultList);
            path.remove(path.size()-1);
        }
    }

    private String cal(List<Integer> input) {
        return input.stream().map(String::valueOf).collect(Collectors.joining("->"));
    }
}
