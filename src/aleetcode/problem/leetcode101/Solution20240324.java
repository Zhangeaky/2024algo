package aleetcode.problem.leetcode101;

import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-100-liked">对称二叉树</a>
 */
public class Solution20240324 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        return doExecute(root.left, root.right);
    }

    private boolean doExecute(TreeNode left, TreeNode right) {

        // 无需进行下一次递归的情况
        if (left == null && right == null) {
            return true;
        } else if (left == null && right!=null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left != null && right != null && right.val != left.val) {
            return false;
        }

        // right and left both are not null, and have equivalent value

        boolean a = doExecute(left.left, right.right);

        boolean b = doExecute(left.right, right.left);

        return a && b;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);


        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution20240324 ss = new Solution20240324();
        System.out.println(ss.isSymmetric(root));

    }

}
