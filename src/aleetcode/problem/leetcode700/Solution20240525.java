package aleetcode.problem.leetcode700;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/description/">
 *     二叉搜索树中的搜索</a>
 */
@Solution(number = 700)
public class Solution20240525 {

    @SolutionMethod
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
