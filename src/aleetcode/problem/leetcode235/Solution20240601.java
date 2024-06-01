package aleetcode.problem.leetcode235;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">
 *     二叉搜索树的最近公共祖先</a>
 */
@Solution
public class Solution20240601 {

    @SolutionMethod("二叉搜索树的最近公共祖先，二叉搜索树和普通二叉树的不同之处")
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        // 确定一下pq的顺序
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        return traversal(root, p, q);
    }

    private TreeNode traversal(TreeNode node, TreeNode p, TreeNode q) {

        if (p.val <= node.val && node.val <= q.val) {
            return node;
        }

        if (p.val > node.val) {
            return traversal(node.right, p, q);
        }

        return traversal(node.left, p, q);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);

        root.right = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        root.left = new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5)));

        Solution20240601 ss = new Solution20240601();
        System.out.println(ss.lowestCommonAncestor(root, new TreeNode(888), new TreeNode(999)));
    }
}
