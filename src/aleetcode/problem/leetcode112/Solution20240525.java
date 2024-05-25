package aleetcode.problem.leetcode112;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.List;

@Solution(number = 112)
public class Solution20240525 {

    private boolean exist = false;

    @SolutionMethod("100% + 94.35%" + "但这个方法不太对，遍历了所有的路径，所以递归函数涉及的时候应该有返回值")
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        dfs(root, targetSum);

        return exist;
    }


    private void dfs(TreeNode root, int target) {

        // 递归终止条件
        if (exist || root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            target-= root.val;
            if (target == 0) {
                exist = true;
            }
            return;
        }

        dfs(root.left, target-root.val);

        dfs(root.right, target-root.val);
    }

    @SolutionMethod("100% + 94.35%" + "但这个方法不太对，遍历了所有的路径，所以递归函数涉及的时候应该有返回值")
    public boolean hasPathSum_(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        return dfs_(root, targetSum);
    }

    private boolean dfs_(TreeNode node, int targetSum) {

        if (node.left ==null && node.right ==null) {
            targetSum-=node.val;
            return targetSum == 0;
        }

        // 为减少 当左右节点为空的时候需要多入一次栈 所以提前做判空处理
        if (node.left !=null && dfs_(node.left, targetSum - node.val)) {
            return true;
        }

        if (node.right != null && dfs_(node.right, targetSum - node.val)) {
            return true;
        }

        return false;
    }

}
