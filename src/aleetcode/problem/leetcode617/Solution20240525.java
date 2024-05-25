package aleetcode.problem.leetcode617;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/description/">合并两棵二叉树</a>
 */
@Solution(number = 617)
public class Solution20240525 {

    @SolutionMethod("代码是需要优化的，分那么多种情况是否是有必要的，很多种情况其实是可以合并的。")
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // 以左边的二叉树作为基准，分类讨论
        // 进行前序遍历
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1!=null && root2 == null) {
            TreeNode newLeft = mergeTrees(root1.left, null);
            TreeNode newRight = mergeTrees(root1.right, null);
            root1.left = newLeft;
            root1.right = newRight;
            return root1;
        }

        if (root1 ==null && root2 != null) {
            TreeNode newLeft = mergeTrees(null, root2.left);
            TreeNode newRight = mergeTrees(null, root2.right);
            root1 = new TreeNode(root2.val);
            root1.left = newLeft;
            root1.right = newRight;
            return root1;
        }

        if (root1 != null && root2 != null) {
            TreeNode newLeft = mergeTrees(root1.left, root2.left);
            TreeNode newRight = mergeTrees(root1.right, root2.right);
            root1.val += root2.val;;
            root1.left = newLeft;
            root1.right = newRight;
            return root1;
        }

        return null;
    }
}
