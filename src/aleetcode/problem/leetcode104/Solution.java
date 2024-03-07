package aleetcode.problem.leetcode104;


public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int i = 1 + maxDepth(root.left);

        int j = 1 + maxDepth(root.right);

        return Math.max(i, j);
    }



}
