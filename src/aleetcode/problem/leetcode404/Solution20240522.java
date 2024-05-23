package aleetcode.problem.leetcode404;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/">左叶子之和</a>
 */
@Solution(number = 404)
public class Solution20240522 {

    @SolutionMethod(description = "")
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {

        // 递归终止条件
        {
            // 因为在终止条件里面，是最底层，无法判断当前节点是不是一个左叶子节点，所以都返回0;数值的累加在外层做
            // 如果是子节点或者空节点 返回0，不计数。本题在终止条件的时候无法决策出。
            if (node == null) {
                return 0;
            }

            if (node.left == null && node.right == null) {
                return 0;
            }

        }

        // 当前节点的左孩子 是叶子节点，使我们要的目标。
        int result = 0;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            result += node.left.val;
        }
        result += dfs(node.left);
        result += dfs(node.right);
        return result;
    }

    public static void main(String[] args) {




    }

}
